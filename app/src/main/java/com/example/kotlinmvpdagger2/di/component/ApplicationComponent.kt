package com.example.kotlinmvpdagger2.di.component

import com.example.kotlinmvpdagger2.BaseApp
import com.example.kotlinmvpdagger2.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: BaseApp)
}