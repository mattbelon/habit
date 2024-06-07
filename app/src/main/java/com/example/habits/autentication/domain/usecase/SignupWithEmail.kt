package com.example.habits.autentication.domain.usecase

import com.example.habits.autentication.domain.repository.AuthenticationRepository

class SignupWithEmailUseCase (private val repository: AuthenticationRepository) {
    suspend operator fun invoke(email:String, password:String): Result<Unit>{
        return repository.signUp(email, password)
    }
}