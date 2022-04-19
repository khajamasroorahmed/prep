package com.khajamasroorahmed.network

import com.khajamasroorahmed.network.model.domain.OrderResponse
import com.khajamasroorahmed.network.model.domain.OrdersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipesApi {

    @GET("orders")
    fun fetchOrders(): Call<OrdersResponse>

    @GET("orders")
    suspend fun fetchOrdersSuspend(): OrdersResponse

    @GET("order/{order_id}")
    fun fetchOrderById(@Path("order_id") id: Long): Call<OrderResponse>

    @GET("order/{order_id}")
    suspend fun fetchOrderByIdSuspend(@Path("order_id") id: Long): OrderResponse
}