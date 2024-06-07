package com.example.habits.home.data.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH

interface HomeApi {
    companion object {
        const val BASE_URL = "https://habits-1a229-default-rtdb.firebaseio.com/"
    }

    @GET("habits.json")
    suspend fun getAllHabits(): HabitResponse

    @PATCH("habits.json")
    suspend fun insertHabit(@Body habit: HabitResponse)


}