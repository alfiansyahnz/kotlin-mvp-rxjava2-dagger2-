package com.example.kotlinmvpdagger2.di.component

import com.example.kotlinmvpdagger2.di.module.ActivityModule
import com.example.kotlinmvpdagger2.ui.main.MainActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}