package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import com.example.myapplication.databinding.ActivityLogBinding
import com.example.myapplication.databinding.ActivityRegBinding
import com.example.myapplication.tracker.TrackerActivity


class LogActivity : AppCompatActivity(R.layout.activity_log) {
    private lateinit var binding: ActivityLogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActivity()

    }

    private fun setupActivity() {

        binding.backLogBtn.setOnClickListener {
            finish()
        }

        binding.continueLogButton.setOnClickListener {
            val intent = Intent(this, TrackerActivity::class.java)
            startActivity(intent)
        }
    }




}