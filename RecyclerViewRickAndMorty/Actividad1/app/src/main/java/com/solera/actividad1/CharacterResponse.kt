package com.solera.actividad1

data class CharacterResponse (
    val results:List<Characters>
)
data class Characters(
    val id:Int,
    val name:String,
    val species:String,
    val image:String
)