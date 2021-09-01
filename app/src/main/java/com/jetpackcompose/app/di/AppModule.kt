package com.jetpackcompose.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *  you should give the scope to @InstallIn() to inject something based on this document
 *  https://developer.android.com/training/dependency-injection/hilt-android#component-scopes
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun getSampleText(): String {
        return "Hi this is test of dependency injection"
    }
}