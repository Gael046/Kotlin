package com.example.pokemonapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemonapp.data.Profile
import com.example.pokemonapp.presentation.viewmodels.HomeViewModel

@Composable
fun ProfilePage(homeViewModel: HomeViewModel = viewModel()) {
    Column {
        Text(
            text = "Hello ProfilePage!",
        )
    }
}