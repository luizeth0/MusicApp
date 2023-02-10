package com.example.musicapp

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
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

        if (!isConnected()) {
            android.app.AlertDialog.Builder(this)
                .setTitle("Error Occurred")
                .setMessage("Do you want to exit?")
                .setPositiveButton("Yes") { dialog, _ ->
                    finish()
                    dialog.dismiss()
                }
                .setNegativeButton("Check connection") { dialog, _ ->
                    startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                    finish()
                    dialog.dismiss()
                }
                .create()
                .show()
        }
        else {

            Handler().postDelayed({
                val intent = Intent(this@FullscreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            },2000)

        }
    }

    private fun isConnected(): Boolean {
        val connectivityManager: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network : NetworkInfo? = connectivityManager.activeNetworkInfo
        if (network != null) {
            if (network.isConnected) {
                return true
            }
        }
        return false
    }

}