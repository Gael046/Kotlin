package com.example.pokemonapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.pokemonapp.datasource.api.NetworkDataSource

@Composable
fun HomePage() {

    //TODO to test api
    LaunchedEffect(true) {
        val response = NetworkDataSource.magicCardsService.getCards()
        println(response)
    }

    Column {
        Text(
            text = "Hello HomePage!",
        )
    }
}