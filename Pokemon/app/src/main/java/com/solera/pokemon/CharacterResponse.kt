package com.solera.pokemon

data class CharacterResponse (
    val results:List<Characters>
)

data class Characters(
    val id:Int,
    val name:String,
    val url:String,
    var spriteUrl: String? = null,
    var abilities: List<String>?,
    var moves: List<String>?,
    var types: List<String>?
)
