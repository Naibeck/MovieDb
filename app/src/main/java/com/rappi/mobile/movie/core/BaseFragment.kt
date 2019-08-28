package com.rappi.mobile.movie.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rappi.mobile.movie.viewmodel.FactoryViewModel
import javax.inject.Inject

open class BaseFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: FactoryViewModel

    protected fun <T : ViewModel> getViewModel(viewModelClazz: Class<T>): T {
        val viewModelProvider = ViewModelProviders.of(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application)
        )
        val viewModel = viewModelProvider.get(viewModelClazz)
        viewModelFactory.inject(viewModel)
        return viewModel
    }
}
