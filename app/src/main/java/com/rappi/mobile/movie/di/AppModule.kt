package com.rappi.mobile.movie.di

import android.app.Application
import android.content.Context
import com.rappi.mobile.movie.manager.GenreManager
import com.rappi.mobile.movie.manager.MovieManager
import com.rappi.mobile.movie.network.repository.GenreRepository
import com.rappi.mobile.movie.network.repository.MovieRepository
import com.rappi.mobile.movie.util.NavigationUtil
import com.rappi.mobile.movie.util.ResourceProvider
import com.rappi.mobile.movie.viewmodel.FactoryViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    fun providesContext(): Context = application

    @Provides
    @Singleton
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider(context)

    @Provides
    @Singleton
    fun provideNavigationUtil(): NavigationUtil = NavigationUtil()

    @Provides
    fun provideViewModelFactory(): FactoryViewModel = FactoryViewModel(application)

    @Provides
    fun provideGenreManager(repository: GenreRepository): GenreManager = GenreManager(repository)

    @Provides
    fun provideMovieManager(repository: MovieRepository): MovieManager = MovieManager(repository)
}
