package com.solera.resources

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.solera.resources.databinding.ActivityViewModelBinding

class ViewModel : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.counter.observe(this) { count ->
            binding.tvCounter.text = count.toString()
        }
        binding.btIncrease.setOnClickListener {
            viewModel.increaseCounter()
        }
    }
}
