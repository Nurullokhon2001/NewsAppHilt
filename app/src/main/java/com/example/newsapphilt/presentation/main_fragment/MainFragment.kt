package com.example.newsapphilt.presentation.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapphilt.databinding.FragmentMainBinding
import com.example.newsapphilt.presentation.adapter.NewsAdapter
import com.example.newsapphilt.utill.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel by viewModels<MainVIewModel>()
    private var binding by autoCleared<FragmentMainBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)

        val newsAdapter = NewsAdapter()
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
}