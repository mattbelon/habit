package com.example.habits.home.data.remote

data class HabitDto(
    val name: String,
    val reminder: Long,
    val startDate: Long,
    val frequency: List<Int>,
    val completedDates: List<Long>?
)