package com.example.loudplaynewstask.data;

import com.example.loudplaynewstask.pojo.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    @GET("top-headlines")
    Call<NewsModel> getTopHeadLinesNews(@Query("sources") String sources,@Query("apiKey") String apiKey);
}
