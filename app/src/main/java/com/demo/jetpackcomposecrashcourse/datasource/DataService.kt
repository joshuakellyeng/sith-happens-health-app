package com.demo.jetpackcomposecrashcourse.datasource

import retrofit2.Response
import retrofit2.http.GET

interface DataService {

    @GET("/")
    suspend fun getData(): Response<List<UserResponse>>
}