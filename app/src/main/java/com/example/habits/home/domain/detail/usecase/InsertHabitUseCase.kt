package com.example.habits.home.domain.detail.usecase

import com.example.habits.home.domain.models.Habit
import com.example.habits.home.domain.repository.HomeRepository

class InsertHabitUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(habit: Habit) {
        repository.insertHabit(habit)
    }
}