package com.example.loudplaynewstask.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModel {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<NewsArticleModel> articles = null;



    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<NewsArticleModel> getArticles() {
        return articles;
    }
}
