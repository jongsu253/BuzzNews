package com.buzzvil.news

import com.buzzvil.news.domain.usecase.GetBlogPostsUseCase
import com.buzzvil.news.domain.usecase.GetGistUseCase
import com.buzzvil.news.domain.usecase.UpdateGistUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class App @Inject constructor(
    private val getBlogPostsUseCase: GetBlogPostsUseCase,
    private val getGistUseCase: GetGistUseCase,
    private val updateGistUseCase: UpdateGistUseCase
) {
    fun updateGist() {
        runBlocking {
            val content = getBlogPostsUseCase.execute()
                .flowOn(Dispatchers.IO)
                .toList()
                .take(4)
                .joinToString(separator = "") { "${it.title} (${it.url})\n" }
                .plus("https://www.buzzvil.com")

            getGistUseCase.execute()
                .flowOn(Dispatchers.IO)
                .filter { it.content != content }
                .flatMapMerge {
                    updateGistUseCase.execute(it.copy(content = content))
                }.catch {
                    println(it)
                }.collect {}
        }
    }
}
