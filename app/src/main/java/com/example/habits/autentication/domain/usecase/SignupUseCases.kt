package com.example.habits.autentication.domain.usecase


data class SignupUseCases (
    val signupwithEmailUseCase: SignupWithEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateEmailUseCase: ValidateEmailUseCase,
)