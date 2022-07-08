package com.example.newsapphilt.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapphilt.domain.model.Article

class NewsRecyclerviewDiffUtil(
    private val oldList: List<Article>,
    private val newList: List<Article>
) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }


//    holder.author.text = data.source.name
//    holder.title.text = data.title
//    holder.description.text = data.description
//    holder.time.text = data.publishedAt.substringBefore("T")

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title === newList[newItemPosition].title &&
                oldList[oldItemPosition].description === newList[newItemPosition].description &&
                oldList[oldItemPosition].source?.name === newList[newItemPosition].source?.name &&
                oldList[oldItemPosition].publishedAt === newList[newItemPosition].publishedAt
    }
}