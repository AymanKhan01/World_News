package com.example.world_news.repository

import com.example.world_news.api.RetrofitInstance
import com.example.world_news.db.ArticleDatabase
import com.example.world_news.models.Article

class NewsRepository(val db : ArticleDatabase)  {

        suspend fun getHeadlines(countycode : String , pageNumber : Int)=
            RetrofitInstance.api.getHeadlines(countycode , pageNumber)

        suspend fun searchNews(searchQuery : String , pageNumber : Int)=
            RetrofitInstance.api.searchForNews(searchQuery,  pageNumber)

        suspend fun upsert(article: Article)=db.getArticlesDao().upsert(article)

        fun getFavouriteNews()= db.getArticlesDao().getAllArticles()

        suspend fun deleteArticle(article: Article)= db.getArticlesDao().deleteArticle(article)



}