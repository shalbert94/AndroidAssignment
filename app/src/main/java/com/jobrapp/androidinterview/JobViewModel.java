package com.jobrapp.androidinterview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jobrapp.server.User;

import java.util.List;

import retrofit2.Response;

public class JobViewModel extends AndroidViewModel {
    @NonNull
    private DataRepository repo;
    @NonNull
    private LiveData<Response<List<User>>> jobLiveData;

    public JobViewModel(@NonNull Application application){
        super(application);
        repo = DataRepository.getInstance();
        jobLiveData = repo.getMyLiveData();
    }
    @NonNull
    public LiveData<Response<List<User>>> getLiveData() {
        return jobLiveData;
    }

}
