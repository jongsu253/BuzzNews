package com.buzzvil.news.di

import com.buzzvil.news.data.repository.BlogRepositoryImpl
import com.buzzvil.news.domain.repository.BlogRepository
import com.buzzvil.news.domain.repository.GistRepository
import com.buzzvil.news.github.repository.GistRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        AppModule.AppBindingModule::class
    ]
)
class AppModule {
    @Module
    abstract class AppBindingModule {
        @Binds
        abstract fun bindBlogRepository(blogRepositoryImpl: BlogRepositoryImpl): BlogRepository

        @Binds
        abstract fun bindGistRepository(gistRepositoryImpl: GistRepositoryImpl): GistRepository
    }
}