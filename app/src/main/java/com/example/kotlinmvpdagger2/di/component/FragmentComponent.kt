package com.example.kotlinmvpdagger2.di.component

import com.example.kotlinmvpdagger2.di.module.FragmentModule
import com.example.kotlinmvpdagger2.ui.about.AboutFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(aboutFragment: AboutFragment)
    fun inject(listFragment: com.example.kotlinmvpdagger2.ui.list.ListFragment)
}
