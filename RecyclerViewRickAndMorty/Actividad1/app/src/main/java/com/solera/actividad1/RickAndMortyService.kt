package com.solera.actividad1

import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("character")
    fun getCharacters():Call<CharacterResponse>
}