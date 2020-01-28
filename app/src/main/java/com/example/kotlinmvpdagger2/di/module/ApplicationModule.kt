package com.example.kotlinmvpdagger2.di.module

import com.example.kotlinmvpdagger2.BaseApp
import com.example.kotlinmvpdagger2.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): BaseApp {
        return baseApp
    }

}