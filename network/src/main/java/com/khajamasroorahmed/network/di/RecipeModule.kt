package com.khajamasroorahmed.network.di

import com.khajamasroorahmed.network.RecipeRepository
import com.khajamasroorahmed.network.RecipeRepositoryImpl
import com.khajamasroorahmed.network.RecipesService
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object RecipeModule {
    @Provides
    @Singleton
    internal fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    internal fun provideBaseUrl(): String = "https://boiling-dusk-12902.herokuapp.com/"

    @Provides
    @Singleton
    internal fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    internal fun provideRecipeService(retrofit: Retrofit) = RecipesService(retrofit)

    @Provides
    @Singleton
    fun providesRecipeRepository(
        service: RecipesService,
        dispatcher: CoroutineDispatcher
    ): RecipeRepository = RecipeRepositoryImpl(service, dispatcher)
}