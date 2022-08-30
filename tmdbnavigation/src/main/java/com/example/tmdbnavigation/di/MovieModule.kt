package com.example.tmdbnavigation.di

import com.example.tmdbnavigation.data.service.MovieAPI
import com.example.tmdbnavigation.data.sources.MovieRepositoryImpl
import com.example.tmdbnavigation.data.sources.MoviesRemoteSource
import com.example.tmdbnavigation.data.sources.MoviesRemoteSourceImpl
import com.example.tmdbnavigation.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieBindModule {

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindMovieRemoteSource(moviesRemoteSourceImpl: MoviesRemoteSourceImpl): MoviesRemoteSource
}

@Module
@InstallIn(SingletonComponent::class)
class MovieProvideModule {

    @Provides
    fun provideMovieApi(): MovieAPI {
        return getRetrofit().create(MovieAPI::class.java)
    }

    private fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}