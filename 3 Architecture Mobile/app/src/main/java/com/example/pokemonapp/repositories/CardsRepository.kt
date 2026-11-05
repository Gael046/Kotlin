package com.example.pokemonapp.repositories

import android.util.Log
import com.example.pokemonapp.data.MagicCard
import com.example.pokemonapp.datasource.api.NetworkDataSource

object CardsRepository {

    val networkService = NetworkDataSource.magicCardsService

    suspend fun getCards(): List<MagicCard> {

        val cards = NetworkDataSource.magicCardsService.getCards().cardList
        Log.v("getCards", cards.toString())
        // TODO save in database
        return cards
    }

    suspend fun getCardDetail(id: Int): MagicCard {
        return networkService.getCard(id)
    }

}