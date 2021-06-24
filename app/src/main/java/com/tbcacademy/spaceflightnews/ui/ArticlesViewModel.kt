package com.tbcacademy.spaceflightnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.tbcacademy.spaceflightnews.models.ArticlesItem
import com.tbcacademy.spaceflightnews.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticlesViewModel : ViewModel() {

    private val articles = MutableLiveData<List<ArticlesItem>>().apply {
        mutableListOf<ArticlesItem>()
    }

    val _articlesLiveData: LiveData<List<ArticlesItem>> = articles

    private val loadingLiveData = MutableLiveData<Boolean>()
    val _loadingLiveData: LiveData<Boolean> = loadingLiveData

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getNews()
        }
    }

    private suspend fun getNews() {
        loadingLiveData.postValue(true)
        val result = RetrofitInstance.api.getArticles()
        if (result.isSuccessful) {
            val items = result.body()
            articles.postValue(items)
        }
        loadingLiveData.postValue(false)

    }


}