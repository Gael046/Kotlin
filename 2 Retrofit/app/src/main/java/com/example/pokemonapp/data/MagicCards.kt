package com.example.pokemonapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MagicCards(@SerialName("cards") val cardList: List<MagicCard>)

@Serializable
data class MagicCard(
    val id: String,
    val image: String?,
    val localId: String,
    val name: String,
    val pricing: Pricing
)

@Serializable
data class Pricing(
    val cardmarket: CardMarket?
)

@Serializable
data class CardMarket(
    val avg: Double?,
    val unit: String?
)