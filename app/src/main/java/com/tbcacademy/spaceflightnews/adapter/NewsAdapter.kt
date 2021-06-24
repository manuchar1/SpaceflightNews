package com.tbcacademy.spaceflightnews.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tbcacademy.spaceflightnews.databinding.ItemArticleBinding
import com.tbcacademy.spaceflightnews.models.ArticlesItem


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val articles = mutableListOf<ArticlesItem>()



    inner class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: ArticlesItem

        @SuppressLint("WrongConstant")
        fun bind() {
            model = articles[adapterPosition]
            itemView.apply {
                Glide.with(this).load(model.imageUrl).into(binding.ivImage)
                binding.tvTItle.text = model.title
                binding.tvUpdateAt.text = model.publishedAt

                setOnClickListener {
                    onItemClickListener?.let { it(model) }
                }

            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }


    private var onItemClickListener: ((ArticlesItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (ArticlesItem) -> Unit) {
        onItemClickListener = listener

    }




    override fun getItemCount() = articles.size

    fun setData(articles: MutableList<ArticlesItem>) {
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }
}