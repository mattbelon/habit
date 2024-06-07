package com.example.habits.autentication.data.repository

import com.example.habits.autentication.domain.repository.AuthenticationRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

class AuthenticationRepositoryImpl: AuthenticationRepository {
    override suspend fun login(email: String, password: String): Result<Unit> {
        return try{
            Firebase.auth.signInWithEmailAndPassword(email,password).await()
            Result.success(Unit)
        } catch(e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun signUp(email: String, password: String): Result<Unit> {
        return try{
            Firebase.auth.createUserWithEmailAndPassword(email,password).await()
            Result.success(Unit)
        } catch(e:Exception){
            Result.failure(e)
        }
    }

    override fun getUserId(): String? {
        return Firebase.auth.currentUser?.uid
    }
}