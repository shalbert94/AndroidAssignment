package com.jobrapp.androidinterview

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jobrapp.server.User
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var model: JobViewModel
    private var jobAdapter:JobAdapter?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProviders.of(this).get(JobViewModel::class.java)
        val dataObserver = Observer<Response<List<User>>> {
            result->updateUi(result)
        }
        model.liveData.observe(this, dataObserver)
        jobAdapter= JobAdapter()
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager =GridLayoutManager(this, 2);
        layoutManager.orientation=RecyclerView.VERTICAL
        recyclerView.layoutManager= layoutManager
        recyclerView.adapter=jobAdapter
        DataRepository.getInstance().loadData()
    }

    fun updateUi(result:Response<List<User>>?){
        if (result!!.isSuccessful){
            jobAdapter?.addAll(result.body())
            Log.d("MainActivity", result.toString())

        }


    }
}
