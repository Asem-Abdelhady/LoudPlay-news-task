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
import com.squareup.picasso.Picasso;

import java.util.List;

public class HeadlinesNewsAdapter extends RecyclerView.Adapter<HeadlinesNewsAdapter.HeadlinesNewsViewHolder> {
    private List<NewsArticleModel> articles;
    private AdapterListener listener;

    public HeadlinesNewsAdapter(List<NewsArticleModel> newsArticleModels, AdapterListener listener) {
        this.articles = newsArticleModels;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HeadlinesNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HeadlinesNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.headlines_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlinesNewsViewHolder holder, int position) {
        holder.bind(articles.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    public class HeadlinesNewsViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsDescription;
        ImageView newsImage;

        public HeadlinesNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.textview_news_title);
            newsDescription = itemView.findViewById(R.id.textview_news_description);
            newsImage = itemView.findViewById(R.id.image_news_image);
        }

        public void bind(NewsArticleModel article, AdapterListener listener) {
            newsTitle.setText(article.getTitle());
            newsDescription.setText(article.getDescription());
            Picasso.get().load(article.getUrlToImage()).into(newsImage);
            itemView.setOnClickListener(view -> listener.OnItemClickListener(article));
        }
    }


}
