package com.example.habits.onboarding.data.repository

import android.content.SharedPreferences
import com.example.habits.onboarding.domain.repository.OnboardingRepository
import com.example.habits.onboarding.domain.usecase.HasSeenOnboardingUseCase

class OnboardingRepositoryImpl(
    private val sharedPreferences: SharedPreferences): OnboardingRepository

{
    companion object {
        private const val HAS_SEEN_ONBOARDING ="has_seen_onboarding"}
    override fun hasSeenOnboarding(): Boolean {
        return sharedPreferences.getBoolean(HAS_SEEN_ONBOARDING, false)
    }

    override fun completedOnboarding() {
        return sharedPreferences.edit().putBoolean(HAS_SEEN_ONBOARDING,true).apply()
    }
}