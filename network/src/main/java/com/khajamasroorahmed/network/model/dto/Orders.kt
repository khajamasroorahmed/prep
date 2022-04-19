package com.khajamasroorahmed.network.model.dto

data class Orders(
    val data: Map<Long, Order>,
)

data class Order(
    val items: List<Item>
)

data class Item(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val count: Int,
)