package com.example.pokemonapp.presentation.viewmodels

import com.example.pokemonapp.data.MagicCard

data class HomeUIState(
    val magicCards: List<MagicCard>,
    val cardDetail: MagicCard?,
    val color: String,
    val isLoading: Boolean = false)
