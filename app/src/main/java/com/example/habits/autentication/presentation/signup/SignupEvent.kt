package com.example.habits.autentication.presentation.signup

sealed interface SignupEvent {
    data class EmailChange(val email: String) : SignupEvent
    data class PasswordChange(val password: String) : SignupEvent
    object SignIn : SignupEvent
    object SignUp : SignupEvent
}
