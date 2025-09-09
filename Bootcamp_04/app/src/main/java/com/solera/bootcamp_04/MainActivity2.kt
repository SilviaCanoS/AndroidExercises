package com.solera.bootcamp_04

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.solera.bootcamp_04.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tv.text = intent.getStringExtra("VERSE")
        val counter = intent.getIntExtra("COUNTER", 0) + 1

        binding.button.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("COUNTER", counter)
            startActivity(intent)
        }
    }
}