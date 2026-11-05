package com.example.pokemonapp.datasource.api

import com.example.pokemonapp.data.MagicCard
import com.example.pokemonapp.data.MagicCards
import retrofit2.http.GET
import retrofit2.http.Path

interface MagicCardService {

    @GET("cards")
    suspend fun getCards(): MagicCards

    @GET("cards/{id}")
    suspend fun getCard(@Path("id") idCard: Int): MagicCard

}