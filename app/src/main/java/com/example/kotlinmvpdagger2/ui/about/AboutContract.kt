package com.example.kotlinmvpdagger2.ui.about

import com.example.kotlinmvpdagger2.ui.base.BaseContract

class AboutContract {

    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun loadMessageSucces(message: String)
        fun loadMessageError()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadMessage() // ini asumsinya kita bakal request ke retrofit

    }
}