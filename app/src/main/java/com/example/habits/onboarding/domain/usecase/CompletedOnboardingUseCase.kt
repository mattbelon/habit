package com.example.habits.onboarding.domain.usecase

import android.content.SharedPreferences
import com.example.habits.onboarding.domain.repository.OnboardingRepository

class CompletedOnboardingUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke(){
        repository.completedOnboarding()
    }
}