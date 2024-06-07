package com.example.habits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.habits.navigation.NavigationHost
import com.example.habits.navigation.NavigationRoute
import com.example.habits.ui.theme.HabitsTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewmodel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationHost(
                        navHostController = navController,
                        startDestination = getStartDestination()
                    )

                }
            }
        }
    }

    private fun getStartDestination():NavigationRoute{
        if (viewmodel.isLoggedIn){
            return NavigationRoute.Home
        }
        return if(viewmodel.hasSeenOnboarding){
            NavigationRoute.Login
        } else {
            NavigationRoute.Onboarding
        }
    }
}
