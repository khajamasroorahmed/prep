package com.khajamasroorahmed.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RecipesService @Inject constructor(retrofit: Retrofit) {
    val api: RecipesApi = retrofit.create(RecipesApi::class.java)
}