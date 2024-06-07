package com.example.habits.home.domain.home.usecase

import com.example.habits.home.domain.models.Habit
import com.example.habits.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class GetHabitsForDateUseCase(
    private val repository: HomeRepository
) {
    operator fun invoke(date: ZonedDateTime): Flow<List<Habit>> {
        return repository.getAllHabitsForSelectedDate(date).distinctUntilChanged().map { it ->
            it.filter { it.frequency.contains(date.dayOfWeek) }
        }
    }
}