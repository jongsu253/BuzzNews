package com.buzzvil.news.domain.usecase

import com.buzzvil.news.domain.model.Post
import com.buzzvil.news.domain.repository.BlogRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBlogPostsUseCase @Inject constructor(
    private val blogRepository: BlogRepository
) {
    fun execute(): Flow<Post> = blogRepository.getPosts()
}