package com.buzzvil.news.di

import javax.inject.Qualifier

interface Qualifiers

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BlogBaseUrl
