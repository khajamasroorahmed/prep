package com.khajamasroorahmed.preparation.di

import com.khajamasroorahmed.network.di.RecipeModule
import com.khajamasroorahmed.preparation.MainActivity
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [RecipeModule::class])
interface AppComponent {
}