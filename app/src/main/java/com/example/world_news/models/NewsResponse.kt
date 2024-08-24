package com.example.world_news.models

import com.example.world_news.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)