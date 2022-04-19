package com.khajamasroorahmed.network.model.domain

import com.khajamasroorahmed.network.model.dto.Item
import com.squareup.moshi.Json

data class DeliveryItem(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "imageUrl") val imageUrl: String,
    @field:Json(name = "count") val count: Int
) {
    fun toDto(): Item = Item(id = id, name = name, imageUrl = imageUrl, count = count)
}