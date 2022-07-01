package com.example.newsapphilt.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapphilt.R
import com.example.newsapphilt.domain.model.Article

class NewsRecyclerview : RecyclerView.Adapter<NewsRecyclerview.NewsViewHolder>() {

    private var newsList = emptyList<Article>()

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.findViewById<ImageView>(R.id.news_image)
        var title = view.findViewById<TextView>(R.id.news_title)
        var description = view.findViewById<TextView>(R.id.news_description)
        var time = view.findViewById<TextView>(R.id.news_time)
        var author = view.findViewById<TextView>(R.id.news_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val data = newsList[position]
        holder.author.text = data.author
        holder.title.text = data.title
        holder.description.text = data.description
        holder.time.text = data.publishedAt
      //  holder.image.setImageResource()
    }

    override fun getItemCount() = newsList.size
}