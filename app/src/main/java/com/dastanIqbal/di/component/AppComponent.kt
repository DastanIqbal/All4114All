package com.dastanIqbal.di.component

import android.app.Application
import com.dastanIqbal.App
import com.dastanIqbal.di.module.AppModule
import com.dastanIqbal.di.module.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            AndroidInjectionModule::class,
            ActivityBindingModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
