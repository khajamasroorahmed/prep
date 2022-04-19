package com.khajamasroorahmed.network

import com.khajamasroorahmed.network.model.dto.Order
import com.khajamasroorahmed.network.model.dto.Orders
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val service: RecipesService,
    private val dispatcher: CoroutineDispatcher
): RecipeRepository {
    override suspend fun fetchOrders(): Orders {
        return withContext(dispatcher) {
            service.api.fetchOrdersSuspend().orders.associateWith { id ->
                service.api.fetchOrderByIdSuspend(id).items.map { it.toDto() }.let { Order(it) }
            }
            .let {
                Orders(data = it)
            }
        }
    }
}

interface RecipeRepository {
    suspend fun fetchOrders(): Orders
}