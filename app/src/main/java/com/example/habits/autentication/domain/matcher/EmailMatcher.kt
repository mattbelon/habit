package com.example.habits.autentication.domain.matcher

interface EmailMatcher {
    fun isValid(email:String) : Boolean
}