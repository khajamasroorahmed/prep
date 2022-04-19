package com.khajamasroorahmed.network.model.domain

import com.khajamasroorahmed.network.model.dto.Item
import com.khajamasroorahmed.network.model.dto.Order
import com.squareup.moshi.Json

data class OrderResponse(
    @field:Json(name = "items") val items: List<DeliveryItem>
)