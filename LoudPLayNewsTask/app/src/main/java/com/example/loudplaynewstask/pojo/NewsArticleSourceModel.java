package com.example.loudplaynewstask.pojo;

import com.google.gson.annotations.SerializedName;

public class NewsArticleSourceModel {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
