package com.example.habits.onboarding.domain.repository

interface OnboardingRepository {

    fun hasSeenOnboarding():Boolean
    fun completedOnboarding()

}