package com.solera.resources

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.solera.resources.databinding.ActivityCardsBinding
import com.solera.resources.databinding.ActivityMainBinding

class Cards : AppCompatActivity() {
    private lateinit var binding: ActivityCardsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val messageList = listOf(
            Message(message = "Weddings are basically funerals with cake", image = R.drawable.car_sunset),
            Message(message = "What people call love is just a chemical reaction that compels animals to breed", image = R.drawable.deep_ocean),
            Message(message = "Nobody exists on purpose, nobody belongs anywhere, everybody's gonna die", image = R.drawable.house),
            Message(message = "School is not a place for smart people", image = R.drawable.leaving_earth),
            Message(message = "Your boss mean nothing, I've seen what makes you cheer", image = R.drawable.lighthouse),
            Message(message = "I'm sorry but your opinion means very little to me", image = R.drawable.stars_night),
            Message(message = "Existence is pain", image = R.drawable.field_sunset),
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this@Cards)
        binding.recyclerView.adapter = MessageAdapter(messageList)
    }
}
