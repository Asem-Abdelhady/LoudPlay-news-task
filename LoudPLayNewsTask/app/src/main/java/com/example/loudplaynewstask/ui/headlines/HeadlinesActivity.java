package com.example.loudplaynewstask.ui.headlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.loudplaynewstask.R;
import com.example.loudplaynewstask.pojo.NewsModel;

import java.util.List;

public class HeadlinesActivity extends AppCompatActivity {

    HeadlinesViewModel headlinesViewModel;
    RecyclerView headlinesNewsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headlines);
        headlinesViewModel = ViewModelProviders.of(this).get(HeadlinesViewModel.class);
        headlinesViewModel.getPosts();

        headlinesNewsContainer = findViewById(R.id.recycler_headlines_news_container);


        headlinesViewModel.errorMessage.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("HeadlinesActivity", s);
            }
        });

        headlinesViewModel.newsMutableLiveDate.observe(this, new Observer<NewsModel>() {
            @Override
            public void onChanged(NewsModel newsModel) {
                final HeadlinesNewsAdapter headlinesNewsAdapter = new HeadlinesNewsAdapter(newsModel.getArticles());
                headlinesNewsContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                headlinesNewsContainer.setAdapter(headlinesNewsAdapter);
            }
        });
    }
}