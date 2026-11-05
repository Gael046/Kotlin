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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokemonapp.app.AppButton
import com.example.pokemonapp.datasource.api.NetworkDataSource
import com.example.pokemonapp.presentation.viewmodels.HomeViewModel
import com.example.pokemonapp.ui.theme.Margin
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomePage(
    homeViewModel: HomeViewModel = viewModel()
) {

    val uiState = homeViewModel.uiState.collectAsStateWithLifecycle()

    //TODO to test api
    LaunchedEffect(true) {
//        homeViewModel.fetchCards()
    }

    if (uiState.value.isLoading) {
        Text(
            text = "Chargement en  cours"
        )
    } else {

    Column(modifier = Modifier.fillMaxWidth()) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val count = uiState.value.magicCards.count()
            Text(
                text = "Nombre de carte $count"
            )

            AppButton(
                text = "Bonjour Clic ", maxWidth = true,
            ) {
                homeViewModel.fetchCards()
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
}