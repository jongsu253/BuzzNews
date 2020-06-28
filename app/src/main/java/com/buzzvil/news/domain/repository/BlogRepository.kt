package com.buzzvil.news.domain.repository

import com.buzzvil.news.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface BlogRepository {
    fun getPosts(): Flow<Post>
}