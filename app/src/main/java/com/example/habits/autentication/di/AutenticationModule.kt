package com.example.habits.autentication.di

import com.example.habits.autentication.data.matcher.EmailMatcherImpl
import com.example.habits.autentication.data.repository.AuthenticationRepositoryImpl
import com.example.habits.autentication.domain.matcher.EmailMatcher
import com.example.habits.autentication.domain.repository.AuthenticationRepository
import com.example.habits.autentication.domain.usecase.GetUserIdUseCase
import com.example.habits.autentication.domain.usecase.LoginUseCases
import com.example.habits.autentication.domain.usecase.LoginWithEmailUseCase
import com.example.habits.autentication.domain.usecase.SignupUseCases
import com.example.habits.autentication.domain.usecase.SignupWithEmailUseCase
import com.example.habits.autentication.domain.usecase.ValidateEmailUseCase
import com.example.habits.autentication.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {
    @Provides
    @Singleton
    fun provideAuthenticationRepository(): AuthenticationRepository {
        return AuthenticationRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providesEmailMatcher(): EmailMatcher {
        return EmailMatcherImpl()
    }

    @Provides
    @Singleton
    fun provideSignupUseCase(
        repository: AuthenticationRepository,
        emailMatcher: EmailMatcher
    ): SignupUseCases {
        return SignupUseCases(
            signupwithEmailUseCase = SignupWithEmailUseCase(repository),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
        )
    }

    @Provides
    @Singleton
    fun provideLoginlUseCase(
        repository: AuthenticationRepository,
        emailMatcher: EmailMatcher
    ): LoginUseCases {
        return LoginUseCases(
            loginWithEmailUseCase = LoginWithEmailUseCase(repository),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
        )
    }

    @Provides
    @Singleton
    fun provideGetUserIdUseCase(repository: AuthenticationRepository): GetUserIdUseCase {
        return GetUserIdUseCase(repository)
    }

}