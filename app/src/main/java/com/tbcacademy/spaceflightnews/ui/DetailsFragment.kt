package com.tbcacademy.spaceflightnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.tbcacademy.spaceflightnews.R
import com.tbcacademy.spaceflightnews.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {


    private val args: DetailsFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_articlesFragment)
        }

        val article = args.article
        Glide.with(this).load(article.imageUrl).into(binding.ivImageDetail)
        binding.tvTItle.text = article.title
        binding.tvUpdateAt.text = article.publishedAt
        binding.tvSummary.text = article.summary
        binding.tvSummary2.text = article.newsSite


    }

}