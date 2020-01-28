package com.example.kotlinmvpdagger2.di.module

import com.example.kotlinmvpdagger2.api.ApiServiceInterface
import com.example.kotlinmvpdagger2.ui.about.AboutContract
import com.example.kotlinmvpdagger2.ui.about.AboutPresenter
import com.example.kotlinmvpdagger2.ui.list.ListContract
import com.example.kotlinmvpdagger2.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    @Provides
    fun provideAboutPresenter(): AboutContract.Presenter {
        return AboutPresenter()
    }
    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideApiService() : ApiServiceInterface {
        return  ApiServiceInterface.create()
    }

}