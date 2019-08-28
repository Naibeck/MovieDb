package com.rappi.mobile.movie.core

import androidx.lifecycle.ViewModel
import com.rappi.mobile.movie.util.NavigationUtil
import javax.inject.Inject

open class BaseViewModel : ViewModel() {
    @Inject
    lateinit var navigationUtil: NavigationUtil
}
