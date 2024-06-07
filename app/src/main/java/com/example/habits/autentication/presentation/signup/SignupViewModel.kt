package com.example.habits.autentication.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habits.autentication.domain.usecase.PasswordResult
import com.example.habits.autentication.domain.usecase.SignupUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCases: SignupUseCases,
): ViewModel() {
    var state by mutableStateOf(SignupState())
    private set

    fun onEvent(event : SignupEvent){
        when(event){
            is SignupEvent.EmailChange->{
                state = state.copy(
                    email = event.email
                )
            }

            is SignupEvent.PasswordChange->{
                state = state.copy(
                    password = event.password
                )
            }

            SignupEvent.SignIn ->{
                state = state.copy(
                    login = true
                )
            }

            SignupEvent.SignIn ->{
                signUp()
            }

            else -> {}
        }
    }

    private fun signUp() {
        state = state.copy(
            emailError = null,
            passwordError = null,
        )
        if (!signupUseCases.validateEmailUseCase(state.email)){
            state = state.copy(
                emailError = "Email invalido"
            )
        }
        val passwordResult = signupUseCases.validatePasswordUseCase(state.password)
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
                signupUseCases.signupwithEmailUseCase(state.email, state.password)
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