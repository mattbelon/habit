package com.example.habits.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habits.R
import com.example.habits.onboarding.presentation.components.OnboardingPager


@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel(),
    onFinish: () -> Unit
) {
    LaunchedEffect(key1 = viewModel.hasSeenOnboarding)
    {
        if (viewModel.hasSeenOnboarding) {
            onFinish()
        }
    }

    val pager = listOf(
        OnboardingPagerInformation(
            "Welcome to monumental habits",
            "We can help you to be a better version of yourself",
            R.drawable.onboarding1
        ),
        OnboardingPagerInformation(
            "Create new habits easily",
            "Second step",
            R.drawable.onboarding2
        ),
        OnboardingPagerInformation(
            "Keep track of your progress",
            "Third step",
            R.drawable.onboarding3
        ),
        OnboardingPagerInformation(
            "Join a supportive community",
            "Fourth step",
            R.drawable.onboarding4
        ),
    )

    OnboardingPager(pages = pager, onFinish = {
        viewModel.completeOnboarding()
    })
}