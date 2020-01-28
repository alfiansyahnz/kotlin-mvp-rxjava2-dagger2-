package com.example.kotlinmvpdagger2.api

import com.example.kotlinmvpdagger2.models.Album
import com.example.kotlinmvpdagger2.models.Post
import com.example.kotlinmvpdagger2.models.User
import com.example.kotlinmvpdagger2.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    @GET("albums")
    fun getAlbumList(): Observable<List<Album>>

    @GET("albums/{id}")
    fun getAlbum(@Path("id") id: Int): Observable<Album>

    @DELETE("albums/{id}")
    fun deleteAlbum(@Path("id") id: Int)

    @GET("posts")
    fun getPostList(): Observable<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Observable<Post>

    @DELETE("albums/{id}")
    fun deletePost(@Path("id") id: Int)

    @GET("users")
    fun getUserList(): Observable<List<User>>

    @GET("posts/{id}")
    fun getUser(@Path("id") id: Int): Observable<User>

    @DELETE("albums/{id}")
    fun deleteUser(@Path("id") id: Int)

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }

}