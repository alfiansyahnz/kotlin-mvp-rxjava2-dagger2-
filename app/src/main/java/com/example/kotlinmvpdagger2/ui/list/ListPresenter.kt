package com.example.kotlinmvpdagger2.ui.list

import com.example.kotlinmvpdagger2.api.ApiServiceInterface
import com.example.kotlinmvpdagger2.models.Album
import com.example.kotlinmvpdagger2.models.DetailViewModel
import com.example.kotlinmvpdagger2.models.Post
import com.example.kotlinmvpdagger2.models.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

class ListPresenter : ListContract.Presenter {

    private val subscription = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: ListContract.View


    override fun loadData() {
        val subscribe = api.getPostList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Post>? ->
                view.showProgress(false)
                view.loadDataSuccess(list!!.take(10))
            }, { error ->
                view.showProgress(false)
                view.showErrorProgress(error.localizedMessage)

            })

        subscription.add(subscribe)
    }

    override fun loadDataAll() {
        val subscribe = Observable.zip(
            api.getPostList(),
            api.getUserList(),
            api.getAlbumList(),
            Function3<List<Post>, List<User>, List<Album>, DetailViewModel> { posts, users, albums ->
                createDetailViewModel(posts, users, albums)
            }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ model: DetailViewModel? ->
                view.showProgress(false)
                view.loadDataAllSuccess(model!!)

            }, { error ->
                view.showProgress(false)
                view.showErrorProgress(error.localizedMessage)

            })

        subscription.add(subscribe)
    }

    override fun deleteItem(item: Post) {
        api.deleteUser(item.id)
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscription.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    private fun createDetailViewModel(
        posts: List<Post>,
        users: List<User>,
        albums: List<Album>
    ): DetailViewModel {

        posts.take(30)
        users.take(30)
        albums.take(30)
        return DetailViewModel(posts, users, albums)

    }
}