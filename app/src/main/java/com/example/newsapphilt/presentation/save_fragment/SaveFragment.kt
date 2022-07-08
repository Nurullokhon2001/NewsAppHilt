package com.example.newsapphilt.presentation.save_fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapphilt.databinding.FragmentSaveBinding
import com.example.newsapphilt.domain.model.Article
import com.example.newsapphilt.presentation.adapter.NewsAdapter
import com.example.newsapphilt.utill.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {

    private val viewModel by viewModels<SaveViewModel>()
    private var binding by autoCleared<FragmentSaveBinding>()
    private var newsData: List<Article>? = null

    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter({ addToFavorite(it) },
            { shareFavorite(it) })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSaveBinding.inflate(inflater, container, false)
        binding.mainNewsList.apply {
            adapter = newsAdapter
        }
        getFavorites()
        return binding.root
    }

    private fun addToFavorite(data: Article) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder)
        {
            setMessage("Аre you sure you want to delete ?")
            setPositiveButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            setNegativeButton("Delete") { dialog, _ ->
                viewModel.deleteFavorite(data.url)
                getFavorites()
                dialog.cancel()
            }
            show()
        }


    }

    private fun shareFavorite(data: Article) {
        val shareText = Intent(Intent.ACTION_SEND)
        shareText.type = "text/plain"
        shareText.putExtra(Intent.EXTRA_SUBJECT, "Subject from my NewsAppHilt")
        shareText.putExtra(Intent.EXTRA_TEXT, data.url)
        startActivity(Intent.createChooser(shareText, "Share Via"))
    }

    private fun getFavorites(){
        viewModel.getFavorites().observe(viewLifecycleOwner) {
            newsData = it.map {newsModel ->
                Article(
                    author = "",
                    content = "",
                    description = newsModel.description,
                    publishedAt = newsModel.publishedAt,
                    source = null,
                    title = newsModel.title,
                    urlToImage = newsModel.urlToImage,
                    url = newsModel.url
                )
            }
            newsAdapter.setData(newsData!!)
        }
    }


}