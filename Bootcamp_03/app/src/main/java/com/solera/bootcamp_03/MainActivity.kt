package com.solera.bootcamp_03

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.solera.bootcamp_03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(){
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("MESSAGE", "Good morning, little star!")
            startActivity(intent)
        }
    }
}