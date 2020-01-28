package com.example.kotlinmvpdagger2.ui.base

class BaseContract {

    interface Presenter<in T>{
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {

    }
}