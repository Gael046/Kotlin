package com.example.pokemonapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MagicCards(@SerialName("cards") val cardList: List<MagicCard>)

@Serializable
data class MagicCard(
    val name: String,
    val manaCost: String? = null,
    var colors: ArrayList<String> = arrayListOf(),
    var type: String? = null,
    var rarity: String? = null
)

