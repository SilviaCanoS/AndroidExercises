package com.solera.resources

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solera.resources.databinding.ActivityMainBinding
import com.solera.resources.databinding.ActivityViewerPagerBinding

class ViewerPager : AppCompatActivity() {
    private lateinit var binding: ActivityViewerPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewerPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = CharacterAdapter(this, 6)
        binding.viewPager.adapter = adapter
    }
}
