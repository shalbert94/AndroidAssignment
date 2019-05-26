package com.jobrapp.androidinterview

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jobrapp.androidinterview.util.AutoFitGridLayoutManager
import com.jobrapp.androidinterview.util.EndlessScrollListener
import com.jobrapp.androidinterview.util.GridDecoration
import com.jobrapp.server.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var model: JobViewModel
    private var jobAdapter:JobAdapter?=null;
    private var progressBar: ProgressBar?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tolbar=findViewById<Toolbar>(R.id.toolbar)
        tolbar.setTitle(R.string.app_name)
        toolbar.setTitleTextColor(Color.WHITE)
        model = ViewModelProviders.of(this).get(JobViewModel::class.java)
        val dataObserver = Observer<Response<List<User>>> {
            result->updateUi(result)
        }
        model.liveData.observe(this, dataObserver)
        jobAdapter= JobAdapter()
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = AutoFitGridLayoutManager(this, resources.getDimensionPixelSize(R.dimen.item_width));
        layoutManager.orientation=RecyclerView.VERTICAL
        val space = resources.getDimension(R.dimen.space).toInt()
        val spanCount = Math.max(1, (recyclerView.getMeasuredWidth() / resources.getDimension(R.dimen.item_width)).toInt())
        val gridDecoration = GridDecoration(spanCount, space)
        recyclerView.addItemDecoration(gridDecoration)
        recyclerView.layoutManager= layoutManager
        recyclerView.adapter=jobAdapter
        DataRepository.getInstance().loadData()
        progressBar=findViewById(R.id.progressBar)
        progressBar!!.visibility= View.VISIBLE
        recyclerView.addOnScrollListener(object: EndlessScrollListener(layoutManager){
            override fun loadBottom() {
                DataRepository.getInstance().loadData()
                progressBar!!.visibility= View.VISIBLE
            }

            override fun loadTop() {
                TODO("not implemented")
            }
        })
    }

    fun updateUi(result:Response<List<User>>?){
        if (result!!.isSuccessful){
            progressBar!!.visibility= View.GONE
            jobAdapter?.addAll(result.body())
        }else{
            Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
        }


    }
}
