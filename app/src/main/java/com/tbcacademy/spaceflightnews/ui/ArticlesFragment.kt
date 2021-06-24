package com.tbcacademy.spaceflightnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tbcacademy.spaceflightnews.R
import com.tbcacademy.spaceflightnews.adapter.NewsAdapter
import com.tbcacademy.spaceflightnews.databinding.ArticlesFragmentBinding

class ArticlesFragment : Fragment() {

    private var adapter = NewsAdapter()

    private lateinit var binding: ArticlesFragmentBinding

    private val viewModel by viewModels<ArticlesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArticlesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()

        viewModel._articlesLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it.toMutableList())
            hideProgressBar()

        })

        viewModel.init()
        initRecycler()
        detailsFragment()
    }

    private fun initRecycler() {
        adapter = NewsAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.adapter = adapter


    }

    private fun detailsFragment() {
        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_articlesFragment_to_detailsFragment,
                bundle
            )

        }
    }


    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE

    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE

    }



}