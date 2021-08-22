package com.example.loudplaynewstask.pojo;

public class NewsModel {
    private String status;
    private int totalResults;
    private NewsArticleModel[] articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public NewsArticleModel[] getArticles() {
        return articles;
    }
}
