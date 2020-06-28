package com.buzzvil.news.github

import com.buzzvil.news.github.model.Gist
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface GistApiService {
    @GET("gists/{gist_id}")
    suspend fun getGist(@Path("gist_id") gistId: String): Gist

    @PATCH("gists/{gist_id}")
    suspend fun updateGist(
        @Path("gist_id") gistId: String,
        @Body files: Gist
    ): Gist
}