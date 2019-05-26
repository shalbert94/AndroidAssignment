package com.jobrapp.androidinterview

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jobrapp.server.User
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var model: JobViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProviders.of(this).get(JobViewModel::class.java)
        val dataObserver = Observer<Response<List<User>>> {
            result->updateUi(result)
        }
        model.liveData.observe(this, dataObserver)
        DataRepository.getInstance().loadData()
    }

    fun updateUi(result:Response<List<User>>?){
        if (result!!.isSuccessful){
            Log.d("MainActivity", result.toString())

        }


    }
}
