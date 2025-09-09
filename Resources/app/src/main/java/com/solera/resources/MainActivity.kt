package com.solera.resources

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solera.resources.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        val airplaneReceiver = Receiver()
        registerReceiver(airplaneReceiver, intentFilter)

        binding.bt.setOnClickListener {
            intent = Intent(this, Widgets::class.java)
            //intent.putExtra("VERSE", song[counter])
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemID = item.getItemId()
        if (itemID == R.id.action_search) {
            Toast.makeText(this, "You clicked Search", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Adapters::class.java)
            startActivity(intent)
        }
        else if (itemID == R.id.action_home) {
            Toast.makeText(this, "You clicked Home", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Cards::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
