package com.example.loudplaynewstask.pojo;

import com.google.gson.annotations.SerializedName;

public class NewsArticleSourceModel {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
