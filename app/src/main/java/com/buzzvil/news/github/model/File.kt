package com.buzzvil.news.github.model

import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("filename")
    val fileName: String,
    @SerializedName("content")
    val content: String
)
