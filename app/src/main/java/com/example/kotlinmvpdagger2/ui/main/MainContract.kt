package com.example.kotlinmvpdagger2.ui.main

import com.example.kotlinmvpdagger2.ui.base.BaseContract

class MainContract {

    interface View : BaseContract.View {
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onDrawerOptionAboutClick()
    }

}