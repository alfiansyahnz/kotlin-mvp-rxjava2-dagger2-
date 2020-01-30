package com.example.kotlinmvpdagger2.ui.about

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class AboutPresenter : AboutContract.Presenter {

    private lateinit var view: AboutContract.View

    override fun loadMessage() {
        Observable.just(true).delay(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.showProgress(false)
                view.loadMessageSucces("Success")
            }
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
    }

    override fun attach(view: AboutContract.View) {
        this.view = view
    }

}