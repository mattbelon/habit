package com.example.habits.autentication.presentation.signup


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habits.R
import com.example.habits.autentication.presentation.signup.components.SignupForm

@Composable
fun SignupScreen(
    onSignIn: ()->Unit,
    onLogin: ()->Unit,
    viewModel: SignupViewModel = hiltViewModel()
){
    val state = viewModel.state

    LaunchedEffect(state.isLoggedIn){
        if (state.isLoggedIn){
            onSignIn()
        }
    }



    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
        ) {
        Image(painter = painterResource(id = R.drawable.signup), contentDescription = "sign up")
        SignupForm(state, viewModel::onEvent, modifier = Modifier.fillMaxWidth())
    }

    if(state.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
}