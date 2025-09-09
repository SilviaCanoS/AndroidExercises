package com.solera.bootcamp_04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.solera.bootcamp_04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.contador.observe(this) { valor ->
            binding.tvSaludo.text = "Contador: $valor"
        }

        val song = listOf("I wanna be your slave", "I wanna be your master", "I wanna make your heart beat run like rollercoaster", "I wanna be a good boy", "I wanna be a gangster","That's all")
        var counter = 0

        Log.d("App", saludar("Silvia"))

        binding.button.setOnClickListener{
            viewModel.incrementar()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("VERSE", song[counter])
            intent.putExtra("COUNTER", counter)
            startActivity(intent)
        }

        counter = intent.getIntExtra("COUNTER", 0)
        if(counter >= song.size) counter = 0
        binding.tv.text = song[counter]
        counter ++
        if(counter >= song.size) counter = 0
    }

    private fun saludar (nombre: String): String {
        return "Hola, $nombre"
    }
}