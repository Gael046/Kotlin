package com.example.pokemonapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.pokemonapp.data.MagicCard
import com.example.pokemonapp.datasource.api.NetworkDataSource
import coil.compose.AsyncImage

@Composable
fun HomePage() {

    var card by remember { mutableStateOf<MagicCard?>(null) }

    LaunchedEffect(Unit) {
        try {
            card = NetworkDataSource.magicCardsService.getCardById("me05-001")
        } catch (e: Exception) {
            println("Erreur API : ${e.message}")
        }
    }

    Column {
        Text(text = "Hello HomePage!")

        if (card != null) {
            AsyncImage(
                model = card?.image+"/high.png",
                contentDescription = "Image de la carte"
            );
            Text(
                text = "${card?.pricing?.cardmarket?.avg ?: 0.0} ${card?.pricing?.cardmarket?.unit}"
            )
        }
    }
}