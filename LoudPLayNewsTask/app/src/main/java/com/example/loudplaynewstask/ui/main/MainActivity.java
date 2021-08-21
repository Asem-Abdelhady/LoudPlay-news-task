package com.example.loudplaynewstask.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loudplaynewstask.ui.headlines.HeadlinesActivity;
import com.example.loudplaynewstask.R;
import com.example.loudplaynewstask.ui.topic.TopicNewsActivity;

public class MainActivity extends AppCompatActivity {
    Button headlines, topicNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headlines = findViewById(R.id.button_headlines);
        topicNews = findViewById(R.id.button_topic_news);

        headlines.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), HeadlinesActivity.class));
            finish();
        });


        topicNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TopicNewsActivity.class));
                finish();
            }
        });



    }
}