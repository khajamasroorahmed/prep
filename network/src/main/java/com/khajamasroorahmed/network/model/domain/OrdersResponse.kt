package com.khajamasroorahmed.network.model.domain

import com.squareup.moshi.Json

data class OrdersResponse(@field:Json(name = "orders") val orders: List<Long>)