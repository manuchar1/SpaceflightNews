package com.tbcacademy.spaceflightnews.models


import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class ArticlesItem(
    val events: List<Event>,
    val featured: Boolean,
    val id: Int,
    val imageUrl: String,
    val launches: List<Launche>,
    val newsSite: String,
    val publishedAt: String,
    val summary: String,
    val title: String,
    val url: String
):Serializable