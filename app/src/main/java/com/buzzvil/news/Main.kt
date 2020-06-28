package com.buzzvil.news

import com.buzzvil.news.di.DaggerAppComponent

fun main(args: Array<String>) {
    val blogBaseUrl = "https://www.buzzvil.com"
    val gistBaseUrl = "https://api.github.com/"
    val gistId = args[0]
    val authToken = args[1]

    val app = DaggerAppComponent.factory()
        .create(blogBaseUrl, gistBaseUrl, gistId, authToken).getApp()

    app.updateGist()
}
