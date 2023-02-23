package com.demo.jetpackcomposecrashcourse.datasource

class ApiClient(private val dataService: DataService) {

    suspend fun getData(): List<UserResponse>? {

        val response = dataService.getData()
        val list = response.body()

        return list
    }

}