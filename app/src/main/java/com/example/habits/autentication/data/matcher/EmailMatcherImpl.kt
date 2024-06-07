package com.example.habits.autentication.data.matcher

import android.util.Patterns
import com.example.habits.autentication.domain.matcher.EmailMatcher

class EmailMatcherImpl: EmailMatcher {
    override fun isValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}