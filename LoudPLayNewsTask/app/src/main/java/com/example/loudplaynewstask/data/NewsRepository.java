package com.example.loudplaynewstask.data;

import com.example.loudplaynewstask.pojo.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRepository {
    private final String BASE_URL = "https://newsapi.org/v2/";
    private final NewsInterface newsInterface;
    private static NewsRepository newsRepositoryInstance;

    private NewsRepository(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        newsInterface = retrofit.create(NewsInterface.class);
    }

    public static NewsRepository getInstance(){
        if (newsRepositoryInstance == null) newsRepositoryInstance = new NewsRepository();

        return newsRepositoryInstance;
    }


    public Call<NewsModel> getTopHeadLinesNews(String apiKey){
        return newsInterface.getTopHeadLinesNews(apiKey);
    }



}
