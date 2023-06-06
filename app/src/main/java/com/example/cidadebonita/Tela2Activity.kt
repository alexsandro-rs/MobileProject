package com.example.cidadebonita

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cidadebonita.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btMore = binding.btMore

        btMore.setOnClickListener {
            val intent = Intent(this, Tela3Activity::class.java)
            startActivity(intent)
        }

    }
}