package com.example.newsapphilt.presentation.main_fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapphilt.databinding.FragmentMainBinding
import com.example.newsapphilt.domain.model.Article
import com.example.newsapphilt.presentation.adapter.NewsAdapter
import com.example.newsapphilt.utill.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel by viewModels<MainVIewModel>()
    private var binding by autoCleared<FragmentMainBinding>()

    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter({ addToFavorite(it) },
            { shareFavorite(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.mainNewsList.apply {
            adapter = newsAdapter
        }

        viewModel.getPopularNews().observe(viewLifecycleOwner) {
            it.body().let { model ->
                model?.let {
                    newsAdapter.setData(it.articles)
                }
            }
        }

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
            setNegativeButton("Add to  favorite") { dialog, _ ->
                viewModel.insertNews(data)
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
}