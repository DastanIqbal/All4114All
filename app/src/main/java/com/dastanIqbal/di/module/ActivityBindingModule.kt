package com.dastanIqbal.di.module

import com.dastanIqbal.all4one.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindMainActivity(): MainActivity
}
