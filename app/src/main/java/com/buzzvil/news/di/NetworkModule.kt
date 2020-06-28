package com.buzzvil.news.di

import com.buzzvil.news.github.GistApiService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideHeaderInterceptor(@AuthToken authToken: String): Interceptor = Interceptor {
        val requestBuilder = it.request().newBuilder()
        requestBuilder.addHeader("Authorization", "Bearer $authToken")
        it.proceed(requestBuilder.build())
    }

    @Provides
    fun provideOkHttpClient(headerInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @GistBaseUrl baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()

    @Provides
    fun provideGistApiService(retrofit: Retrofit): GistApiService =
        retrofit.create(GistApiService::class.java)
}