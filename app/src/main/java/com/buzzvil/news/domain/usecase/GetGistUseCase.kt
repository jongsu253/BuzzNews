package com.buzzvil.news.domain.usecase

import com.buzzvil.news.domain.model.GistPost
import com.buzzvil.news.domain.repository.GistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGistUseCase @Inject constructor(
    private val gistRepository: GistRepository
) {
    fun execute(): Flow<GistPost> = gistRepository.getGist()
}
