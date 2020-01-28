package com.example.kotlinmvpdagger2

import android.app.Application
import com.example.kotlinmvpdagger2.di.component.ApplicationComponent
import com.example.kotlinmvpdagger2.di.component.DaggerApplicationComponent
import com.example.kotlinmvpdagger2.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import kotlinx.android.synthetic.*
import okhttp3.internal.Internal.instance

class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setUp()
        when {
            BuildConfig.DEBUG -> {

            }
        }
    }

    fun setUp() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }



}