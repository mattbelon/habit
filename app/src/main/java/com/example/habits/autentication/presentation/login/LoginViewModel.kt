package com.example.habits.autentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habits.autentication.domain.repository.AuthenticationRepository
import com.example.habits.autentication.domain.usecase.LoginUseCases
import com.example.habits.autentication.domain.usecase.LoginWithEmailUseCase
import com.example.habits.autentication.domain.usecase.PasswordResult
import com.example.habits.autentication.domain.usecase.ValidateEmailUseCase
import com.example.habits.autentication.domain.usecase.ValidatePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    private val loginUseCases: LoginUseCases
) :
    ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChange -> {
                state = state.copy(
                    email = event.email
                )
            }

            LoginEvent.Login -> {
                login()
            }

            is LoginEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }


        }
    }

    private fun login() {
        state = state.copy(
            emailError = null,
            passwordError = null,
        )
        if (!loginUseCases.validateEmailUseCase(state.email)){
            state = state.copy(
                emailError = "Email invalido"
            )
        }
        val passwordResult = loginUseCases.validatePasswordUseCase(state.password)
        if (passwordResult is PasswordResult.Invalid){
            state = state.copy(
                passwordError = "Password invalido"
            )
        }
        if (state.emailError == null && state.passwordError == null) {

            state = state.copy(
                isLoading = true
            )

            viewModelScope.launch {
                loginUseCases.loginWithEmailUseCase(state.email, state.password)
                    .onSuccess {
                        state = state.copy(
                        isLoggedIn = true
                    )
                        println()
                    }.onFailure {
                        val error = it.message
                        println(error)
                        state = state.copy(
                            emailError = it.message
                        )
                        // dialog to display the proper error to the user
                    }
                    state = state.copy(
                        isLoading = false
                    )
            }
        }
    }
}