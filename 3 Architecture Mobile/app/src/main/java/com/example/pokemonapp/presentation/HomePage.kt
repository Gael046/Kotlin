package com.example.pokemonapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokemonapp.app.AppButton
import com.example.pokemonapp.datasource.api.NetworkDataSource
import com.example.pokemonapp.ui.theme.Margin

@Composable
fun HomePage() {

    //TODO to test api
    LaunchedEffect(true) {
        val response = NetworkDataSource.magicCardsService.getCards()
        println(response)
    }

    Column(modifier = Modifier.fillMaxWidth()) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello HomePage!",
            )

            AppButton(
                text = "Bonjour Clic ", maxWidth = true,
            ) {

            }
        }


        AppButton(
            text = "Bonjour Clic autre bouton ", maxWidth = false,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            padding = PaddingValues(
                horizontal = Margin.s,
                vertical = Margin.xl
                )
            ) {

        }

    }
}