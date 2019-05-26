package com.jobrapp.androidinterview.vm;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jobrapp.androidinterview.BuildConfig;
import com.jobrapp.server.Server;
import com.jobrapp.server.User;

import java.util.List;

import retrofit2.Response;

public class DataRepository {
    private static DataRepository instance;
    private MutableLiveData<Response<List<User>>> liveData = new MutableLiveData<>();

    public static DataRepository getInstance() {
        if(instance == null) {
            synchronized (DataRepository.class) {
                if(instance == null) {
                    instance = new DataRepository();
                }
            }
        }
        return instance;
    }
    @NonNull
    public LiveData<Response<List<User>>> getMyLiveData() {
        return liveData;
    }
    public void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server server=new Server();
                try {
                    Response<List<User>> retrofitResponse=server.getUsers().execute();
                    liveData.postValue(retrofitResponse);
                } catch (Exception e) {
                    if (BuildConfig.DEBUG){
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

}
