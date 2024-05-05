package com.example.habits.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habits.onboarding.domain.usecase.HasSeenOnboardingUseCase
import com.example.habits.onboarding.presentation.OnboardingScreen
import com.example.habits.onboarding.presentation.OnboardingViewModel

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination:NavigationRoute
) {
    NavHost(navController = navHostController, startDestination = startDestination.route){
        composable(NavigationRoute.Onboarding.route){
            // OnBoarding
            OnboardingScreen(
                onFinish ={
                    navHostController.navigate(NavigationRoute.Login.route)
                }
            )
        }

        composable(NavigationRoute.Login.route){
            // Login
            Text(text = "Login screen")
        }
    }
}