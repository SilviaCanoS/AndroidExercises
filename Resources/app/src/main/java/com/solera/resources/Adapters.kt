package com.solera.resources

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.solera.resources.databinding.ActivityAdaptersBinding
import com.solera.resources.databinding.ActivityMainBinding

//Rick.kt, RecyclerviewAdapter.kt
class Adapters : AppCompatActivity() {
    private lateinit var binding: ActivityAdaptersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdaptersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val rickList = listOf(
            Rick(rickName = "Pickle Rick", rickImage = R.drawable.pickle_rick),
            Rick(rickName = "Toxic Rick", rickImage = R.drawable.toxic_rick),
            Rick(rickName = "Tiny Rick", rickImage = R.drawable.tiny_rick),
            Rick(rickName = "Teddy Bear Rick", rickImage = R.drawable.teddy_bear_rick),
            Rick(rickName = "Rick Prime", rickImage = R.drawable.rick_prime),
            Rick(rickName = "Hippie Rick", rickImage = R.drawable.hippie_rick),
            Rick(rickName = "Doofus Rick", rickImage = R.drawable.doofus_rick)
        )

        binding.recyclerView.layoutManager = GridLayoutManager(this@Adapters,2)
        binding.recyclerView.adapter = RecyclerviewAdapter(rickList)
    }
}
