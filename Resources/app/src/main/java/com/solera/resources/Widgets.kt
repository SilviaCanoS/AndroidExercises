package com.solera.resources

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solera.resources.databinding.ActivityWidgetsBinding
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment

class Widgets : AppCompatActivity() {
    private lateinit var binding: ActivityWidgetsBinding
    private var progress = 0
    private val handler = Handler(Looper.getMainLooper())
    private var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cbDiane.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) Toast.makeText(this, "Diane is selected", Toast.LENGTH_SHORT).show()
        }
        binding.cbBeth.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) Toast.makeText(this, "Beth is selected", Toast.LENGTH_SHORT).show()
        }
        binding.cbSummer.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) Toast.makeText(this, "Summer is selected", Toast.LENGTH_SHORT).show()
        }

        binding.rg.setOnCheckedChangeListener { _: RadioGroup, checkedId: Int ->
            when (checkedId) {
                R.id.rbEarth -> Toast.makeText(this, "You selected Earth Planet", Toast.LENGTH_SHORT).show()
                R.id.rbPurge -> Toast.makeText(this, "You selected Purge Planet", Toast.LENGTH_SHORT).show()
                R.id.rbBird -> Toast.makeText(this, "You selected Bird World", Toast.LENGTH_SHORT).show()
            }
        }

        var spinnerInitialized = false
        val inventionsList = listOf("Portal Gun", "Meeseeks Box", "Butter Robot", "Microverse Battery", "Interdimensional Cable")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, inventionsList)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (spinnerInitialized)
                {
                    val selected = parent.getItemAtPosition(position).toString()
                    Toast.makeText(this@Widgets, "You selected $selected", Toast.LENGTH_SHORT).show()
                }
                else spinnerInitialized = true
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.btnResults.setOnClickListener {
            if (!isRunning) {
                progress = 0
                isRunning = true
                handler.post(runnable)
            }
        }

        binding.btPlay.setOnClickListener {
            val serviceIntent = Intent(this, MusicService::class.java);
            startService(serviceIntent);
            binding.btPlay.isEnabled = false
        }
        binding.btStop.setOnClickListener {
            val serviceIntent = Intent(this, MusicService::class.java);
            stopService(serviceIntent);
            binding.btPlay.isEnabled = true
        }

        binding.btFragment1.setOnClickListener {
            LoadFragment(FirstFragment())
        }
        binding.btFragment2.setOnClickListener {
            LoadFragment(SecondFragment())
        }

        binding.btViewerPager.setOnClickListener {
            val intent = Intent(this, ViewerPager::class.java)
            startActivity(intent)
        }

        binding.btViewModel.setOnClickListener {
            val intent = Intent(this, ViewModel::class.java)
            startActivity(intent)
        }
    }

    private val runnable = object : Runnable {
        override fun run() {
            if (progress < binding.progressBar.max) {
                progress++
                binding.progressBar.progress = progress
                handler.postDelayed(this, 1000) // 1 second
            } else {
                isRunning = false
            }
        }
    }

    fun LoadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit() // save the changes
    }
}
