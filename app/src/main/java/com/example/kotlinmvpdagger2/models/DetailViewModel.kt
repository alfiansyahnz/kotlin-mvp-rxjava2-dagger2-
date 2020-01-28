package com.example.kotlinmvpdagger2.models

import com.google.gson.Gson

class DetailViewModel(val posts: List<Post>, val users: List<User>, val albums: List<Album>) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}