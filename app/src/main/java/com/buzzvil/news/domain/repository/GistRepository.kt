package com.buzzvil.news.domain.repository

import com.buzzvil.news.domain.model.GistPost
import kotlinx.coroutines.flow.Flow

interface GistRepository {
    fun getGist(): Flow<GistPost>

    fun updateGist(gistPost: GistPost): Flow<GistPost>
}
