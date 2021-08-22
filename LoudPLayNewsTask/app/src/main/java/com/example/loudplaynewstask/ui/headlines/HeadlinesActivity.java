package com.example.loudplaynewstask.ui.headlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.loudplaynewstask.R;

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
        //Error in data retrieval
        headlinesViewModel.errorMessage.observe(this, s -> Log.e("HeadlinesActivity", s));
        //Data retrieved
        headlinesViewModel.newsMutableLiveDate.observe(this, newsModel -> {
            final HeadlinesNewsAdapter headlinesNewsAdapter = new HeadlinesNewsAdapter(newsModel.getArticles(), article -> {
                Intent newsWebPage = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));
                startActivity(newsWebPage);
            });
            headlinesNewsContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            headlinesNewsContainer.setAdapter(headlinesNewsAdapter);
        });
    }
}