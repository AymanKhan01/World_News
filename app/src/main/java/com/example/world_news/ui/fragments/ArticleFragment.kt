package com.example.world_news.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import com.example.world_news.R
import com.example.world_news.databinding.FragmentArticleBinding
import com.example.world_news.ui.NewsActivity
import com.example.world_news.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.fragment.navArgs
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var newsViewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()
    private lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                val it = null
                it?.let { it1 -> loadUrl(it1) }
            }
        }

        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to favourites", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun loadUrl(it: Any) {
        TODO("Not yet implemented")
    }
}

private operator fun <T, V> ReadOnlyProperty<T, V>.getValue(t: T, property: KProperty<V?>): V {
    TODO("Not yet implemented")
}

private fun Any.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}

private operator fun Any.getValue(articleFragment: ArticleFragment, property: KProperty<*>) {

}