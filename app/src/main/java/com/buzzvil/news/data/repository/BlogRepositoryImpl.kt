package com.buzzvil.news.data.repository

import com.buzzvil.news.di.BlogBaseUrl
import com.buzzvil.news.domain.model.Post
import com.buzzvil.news.domain.repository.BlogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jsoup.Jsoup
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(
    @BlogBaseUrl private val baseUrl: String
) : BlogRepository {
    override fun getPosts(): Flow<Post> = flow {
        val doc = Jsoup.connect("$baseUrl/ko/blog").get()

        doc.select("#id_ul_blog li").forEach {
            val url = baseUrl + it.getElementsByTag("a").attr("href")
            val title = it.getElementsByClass("tit").text()
            val thumbnailUrl = it.getElementsByTag("img").attr("src")
            val uploadDate = it.getElementsByClass("day").text()

            emit(Post(url, title, thumbnailUrl, uploadDate))
        }
    }
}
