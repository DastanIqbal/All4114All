package com.dastanIqbal.di.module

import com.dastanIqbal.all4one.ui.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment
}
