package com.example.pokemonapp.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.MagicCard
import com.example.pokemonapp.repositories.CardsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel(private val cardRepository: CardsRepository = CardsRepository): ViewModel() {

    init {

    }

//    private val cardRepository = CardsRepository

    private val _uiState = MutableStateFlow(HomeUIState(listOf(), null, "bleu"))
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

//    private val _magicCards: MutableStateFlow<List<MagicCard>> = MutableStateFlow(listOf())
//    val magicCards: StateFlow<List<MagicCard>> = _magicCards.asStateFlow()
//
//    private val _magicCard: MutableStateFlow<MagicCard?> = MutableStateFlow(null)
//    val magicCard: StateFlow<MagicCard?> = _magicCard.asStateFlow()

    fun fetchCards() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(isLoading = true)
            }
            val cards = cardRepository.getCards()
//            _magicCards.update { cards }

            _uiState.update { currentState ->
                currentState.copy(
                    magicCards = cards,
                    isLoading = false)
            }

//            val filteredCards =  cards.filter { card ->
//                card.rarity == "common"
//            }
//            _magicCards.update { filteredCards }

            //val testCards: List<MagicCard> = _magicCards.value
            //magicCards.value = cards
        }
    }

    fun fetchCardDetail(id: Int) {
        viewModelScope.launch {
            val card = cardRepository.getCardDetail(id)
//            _magicCard.update { card }
            _uiState.update { currentState ->
                currentState.copy(cardDetail = card, magicCards = emptyList())
            }
        }
    }
}