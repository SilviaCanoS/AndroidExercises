package com.solera.pokemon

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.solera.pokemon.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var offsetVariable = 0
        getCharacters(offsetVariable)

        binding.btAfter.setOnClickListener{
            offsetVariable += 10
            if(offsetVariable >= 1292) offsetVariable = 1292
            getCharacters(offsetVariable)
        }

        binding.btBefore.setOnClickListener{
            offsetVariable -= 10
            if(offsetVariable <= 0) offsetVariable = 0
            getCharacters(offsetVariable)
        }
    }

    private fun getCharacters(offsetVariable: Int){
        RetrofitClient.service.getCharacters(offset = offsetVariable).enqueue(object: Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful){
                    val characters = response.body()?.results ?: emptyList()

                    var remaining = characters.size
                    for (character in characters){
                        RetrofitClient.service.getPokemonSprite(character.url).enqueue(object: Callback<PokemonSpriteResponse>{
                            override fun onResponse(
                                call: Call<PokemonSpriteResponse>,
                                response: Response<PokemonSpriteResponse>
                            ) {
                                Log.d("MainActivity", "Sprite URL: ${response.body()}")
                                val spriteUrl = response.body()?.sprites?.front_default
                                val abilities = response.body()?.abilities?.map { it.ability.name }
                                val moves = response.body()?.moves?.map { it.move.name }
                                val typesP = response.body()?.types?.map { it.type.name }

                                character.spriteUrl = spriteUrl
                                character.abilities = abilities
                                character.moves = moves
                                character.types = typesP as List<String>?

                                remaining--
                                if (remaining <= 0) {

                                    adapter = Adapter(characters, supportFragmentManager)
                                    binding.rvPokemon.layoutManager = GridLayoutManager(this@MainActivity,2)
                                    binding.rvPokemon.adapter = adapter
                                    setupSearchView()
                                }
                            }

                            override fun onFailure(call: Call<PokemonSpriteResponse>, t: Throwable) {
                                Toast.makeText(this@MainActivity, "Error al obtener el sprite", Toast.LENGTH_LONG).show()
                            }

                        })
                    }
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error al conectar", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupSearchView(){
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText ?: "")
                return true
            }
        })
    }
}