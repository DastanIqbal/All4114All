package com.dastanIqbal.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dastanIqbal.all4one.ui.ListViewModel
import com.dastanIqbal.di.ViewModelKey
import com.dastanIqbal.di.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
