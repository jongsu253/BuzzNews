package com.buzzvil.news.di

import javax.inject.Qualifier

interface Qualifiers

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BlogBaseUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class GistBaseUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class GistId

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthToken