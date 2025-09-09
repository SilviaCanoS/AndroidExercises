package com.solera.pokemon

data class PokemonSpriteResponse(
    val sprites: PokemonSprite,
    val name: String,
    val abilities: List<PokemonAbility>,
    val types:List<PokemonTypes>,
    val moves:List<PokemonMoves>
)

data class PokemonSprite(
    val front_default: String?
)

data class PokemonAbility(
    var ability: AbilityDetail
)

data class AbilityDetail(
    val name: String
)

data class PokemonTypes(
    val type: TypeDetails

)

data class TypeDetails(
    val name: String?
)

data class PokemonMoves(
    val move: MoveDetails
)

data class MoveDetails(
    val name: String,
)
