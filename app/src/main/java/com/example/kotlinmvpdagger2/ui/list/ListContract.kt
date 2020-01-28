package com.example.kotlinmvpdagger2.ui.list

import com.example.kotlinmvpdagger2.models.DetailViewModel
import com.example.kotlinmvpdagger2.models.Post
import com.example.kotlinmvpdagger2.ui.base.BaseContract

class ListContract {

    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorProgress(error: String)
        fun loadDataSuccess(list: List<Post>)
        fun loadDataAllSuccess(model: DetailViewModel)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
        fun loadDataAll()
        fun deleteItem(item: Post)
    }
}