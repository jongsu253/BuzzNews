package com.buzzvil.news.github.repository

import com.buzzvil.news.di.GistId
import com.buzzvil.news.domain.model.GistPost
import com.buzzvil.news.domain.repository.GistRepository
import com.buzzvil.news.github.GistApiService
import com.buzzvil.news.github.model.File
import com.buzzvil.news.github.model.Gist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GistRepositoryImpl @Inject constructor(
    private val gistApiService: GistApiService,
    @GistId private val gistId: String
) : GistRepository {
    override fun getGist(): Flow<GistPost> = flow {
        gistApiService.getGist(gistId).files.values.first().also {
            emit(GistPost(it.fileName, it.content))
        }
    }

    override fun updateGist(gistPost: GistPost): Flow<GistPost> = flow {
        val gist =
            Gist(mutableMapOf(Pair(gistPost.filename, File(gistPost.filename, gistPost.content))))
        gistApiService.updateGist(gistId, gist).files.values.first().also {
            emit(GistPost(it.fileName, it.content))
        }
    }
}
