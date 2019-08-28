package com.rappi.mobile.movie.di.component

import com.rappi.mobile.movie.MainActivity
import com.rappi.mobile.movie.di.AppModule
import com.rappi.mobile.movie.network.di.NetworkModule
import com.rappi.mobile.movie.viewmodel.genre.GenreViewModel
import com.rappi.mobile.movie.viewmodel.movie.MovieViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface UiComponent {

    fun inject(activity: MainActivity)

    fun inject(viewModel: GenreViewModel)
    fun inject(viewModel: MovieViewModel)
}
