package com.example.loudplaynewstask.ui.headlines;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loudplaynewstask.data.NewsRepository;
import com.example.loudplaynewstask.pojo.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeadlinesViewModel extends ViewModel {
    MutableLiveData<NewsModel> newsMutableLiveDate = new MutableLiveData<>();
    MutableLiveData<String> errorMessage = new MutableLiveData<>();
    NewsRepository newsRepository = NewsRepository.getInstance();

    private final String API_KEY = "57e719ca1d674395a9553607a128f8b9";

    public void getPosts() {
        newsRepository.getTopHeadLinesNews(API_KEY).enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                newsMutableLiveDate.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
            }
        });
    }

}
