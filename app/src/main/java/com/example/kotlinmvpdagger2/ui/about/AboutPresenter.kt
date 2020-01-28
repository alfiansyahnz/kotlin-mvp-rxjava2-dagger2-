package com.example.kotlinmvpdagger2.ui.about

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class AboutPresenter : AboutContract.Presenter {

    private lateinit var view: AboutContract.View

    @SuppressLint("CheckResult")
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: AboutContract.View) {
        this.view = view
    }

}