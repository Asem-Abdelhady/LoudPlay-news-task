package com.example.loudplaynewstask.ui.headlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.loudplaynewstask.R;
import com.example.loudplaynewstask.pojo.NewsModel;

import java.util.List;

public class HeadlinesActivity extends AppCompatActivity {

    HeadlinesViewModel headlinesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headlines);
        headlinesViewModel = ViewModelProviders.of(this).get(HeadlinesViewModel.class);
        headlinesViewModel.getPosts();

        headlinesViewModel.newsMutableLiveDate.observe(this, new Observer<NewsModel>() {
            @Override
            public void onChanged(NewsModel newsModel) {

            }
        });
    }
}