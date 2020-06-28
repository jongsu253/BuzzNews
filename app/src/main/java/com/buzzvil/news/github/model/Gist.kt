package com.buzzvil.news.github.model

import com.google.gson.annotations.SerializedName

data class Gist(
    @SerializedName("files")
    val files: Map<String, File>
)
