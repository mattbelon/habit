package com.example.habits.home.domain.home.usecase

data class HomeUseCases(
    val completeHabitUseCase: CompleteHabitUseCase,
    val getHabitsForDateUseCase: GetHabitsForDateUseCase
)