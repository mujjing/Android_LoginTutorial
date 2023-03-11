package com.example.android_logintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.android_logintutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            var id = binding.tvId.toString()
            var password = binding.tvPassword.toString()

            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("알림")
            dialog.setMessage("id = $id, password = $password")
            dialog.show()
        }
    }
}