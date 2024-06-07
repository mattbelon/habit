package com.example.habits.autentication.presentation.signup

data class SignupState(
    val email: String ="",
    val emailError: String? =null,
    val password: String ="",
    val passwordError: String? =null,
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val login: Boolean = false
)
