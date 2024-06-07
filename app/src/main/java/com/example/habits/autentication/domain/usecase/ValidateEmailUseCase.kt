package com.example.habits.autentication.domain.usecase

import com.example.habits.autentication.domain.matcher.EmailMatcher

class ValidateEmailUseCase(private val emailMatcher: EmailMatcher) {
    operator fun invoke(email: String): Boolean {
        return emailMatcher.isValid(email)
    }
}