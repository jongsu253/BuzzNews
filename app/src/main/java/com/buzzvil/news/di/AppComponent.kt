package com.buzzvil.news.di

import com.buzzvil.news.App
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    fun getApp(): App

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @BlogBaseUrl blogBaseUrl: String,
            @BindsInstance @GistBaseUrl gistBaseUrl: String,
            @BindsInstance @GistId gistId: String,
            @BindsInstance @AuthToken authToken: String
        ): AppComponent
    }
}