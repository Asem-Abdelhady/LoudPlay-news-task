package com.example.loudplaynewstask.ui.headlines;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loudplaynewstask.R;
import com.example.loudplaynewstask.pojo.NewsArticleModel;
import com.example.loudplaynewstask.pojo.NewsModel;

import java.util.List;

public class HeadlinesNewsAdapter extends RecyclerView.Adapter<HeadlinesNewsAdapter.HeadlinesNewsViewHolder> {
    private NewsArticleModel[] newsArticleModels;

    @NonNull
    @Override
    public HeadlinesNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HeadlinesNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.headlines_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlinesNewsViewHolder holder, int position) {
        holder.newsTitle.setText(newsArticleModels[position].getTitle());
        holder.newsDescription.setText(newsArticleModels[position].getDescription());


    }

    @Override
    public int getItemCount() {
        return newsArticleModels.length;
    }

    public void setNewsArticleModels(NewsArticleModel[] newsArticleModels) {
        this.newsArticleModels = newsArticleModels;
    }

    public class HeadlinesNewsViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsDescription;
        ImageView imageView;
        public HeadlinesNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.textview_news_title);
            newsDescription = itemView.findViewById(R.id.textview_news_description);
            imageView = itemView.findViewById(R.id.image_news_image);
        }
    }


}
