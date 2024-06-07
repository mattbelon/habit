package com.example.habits.autentication.domain.usecase


class ValidatePasswordUseCase() {
    operator fun invoke (password : String): PasswordResult {
        if (password.length < 4){
            return PasswordResult.Invalid("Debe tener más de 6 caracteres")
        }


        return PasswordResult.Valid
    }
}

sealed class PasswordResult
{
    object Valid : PasswordResult()
    data class Invalid(val errorMessage:String): PasswordResult()
}

