package com.example.habits.autentication.domain.usecase

import com.example.habits.autentication.domain.repository.AuthenticationRepository

class GetUserIdUseCase(
    private val repository:AuthenticationRepository
) {
    operator fun invoke() :String?{
        return repository.getUserId()
    }
}