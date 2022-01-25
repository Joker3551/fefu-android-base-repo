package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegBinding
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class RegActivity : AppCompatActivity(R.layout.activity_reg) {
    private lateinit var binding: ActivityRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActivity()

    }

    private fun setupActivity() {
        binding.backRegBtn.setOnClickListener {
            finish()
        }

        binding.policyRegText.movementMethod = LinkMovementMethod.getInstance()

        binding.continueRegButton.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)

        }


    }
}