package com.example.kotlinmvpdagger2.di.component

import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.example.kotlinmvpdagger2.di.module.FragmentModule
import com.example.kotlinmvpdagger2.ui.about.AboutFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(aboutFragment: AboutFragment)
    fun inject(listFragment: ListFragment)
}
