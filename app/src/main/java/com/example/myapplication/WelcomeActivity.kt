package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.myapplication.databinding.ActivityMainBinding

class WelcomeActivity() : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActivity()
    }

    private fun setupActivity() {
        binding.regButton.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
        binding.logButton.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }
    }
}

