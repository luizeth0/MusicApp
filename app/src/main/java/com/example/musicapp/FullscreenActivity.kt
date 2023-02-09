package com.example.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.musicapp.databinding.ActivityFullscreenBinding


@Suppress("DEPRECATION")
class FullscreenActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFullscreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this@FullscreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }

}