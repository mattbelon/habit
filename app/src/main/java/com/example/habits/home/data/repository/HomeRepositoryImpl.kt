package com.example.habits.home.data.repository

import android.util.Log
import com.example.habits.home.data.extension.toStartOfDateTimestamp
import com.example.habits.home.data.local.HomeDao
import com.example.habits.home.data.mapper.toDomain
import com.example.habits.home.data.mapper.toDto
import com.example.habits.home.data.mapper.toEntity
import com.example.habits.home.data.remote.HomeApi
import com.example.habits.home.data.remote.util.resultOf
import com.example.habits.home.domain.models.Habit
import com.example.habits.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.*
import java.time.ZonedDateTime
class HomeRepositoryImpl(
    private val dao: HomeDao,
    private val api: HomeApi
) : HomeRepository {
    override fun getAllHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>> {
        val localFlow = dao.getAllHabitsForSelectedDate(date.toStartOfDateTimestamp())
            .map { it.map { it.toDomain() } }
        val apiFlow = getHabitsFromApi()

        return localFlow.combine(apiFlow) { db, _ ->
            db
        }
    }

    private fun getHabitsFromApi(): Flow<List<Habit>> {
        return flow {
            resultOf {
                val habits = api.getAllHabits().toDomain()
                insertHabits(habits)
            }
            emit(emptyList<Habit>())
        }.onStart {
            emit(emptyList())
        }
    }

    override suspend fun insertHabit(habit: Habit) {
        dao.insertHabit(habit.toEntity())
        resultOf {
            api.insertHabit(habit.toDto())
        }.onFailure {
            it.message?.let { it1 -> Log.d("TEST_FIREBASE", it1) }
        }
    }

    private suspend fun insertHabits(habits: List<Habit>) {
        dao.insertHabits(habits.map { it.toEntity() })
    }

    override suspend fun getHabitById(id: String): Habit {
        return dao.getHabitById(id).toDomain()
    }
}