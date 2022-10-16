package com.example.complexevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.complexevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSaveButtonOnClickListener()
    }

    private fun setSaveButtonOnClickListener() {
        binding.btThirdTask.setOnClickListener {
            saveText()
        }
    }

    private fun saveText() {
        if (binding.cbThirdTask.isChecked) {
            binding.tvThirdTask.text = binding.etThirdTask.text
            if (binding.pbThirdTask.progress == binding.pbThirdTask.max) {
                binding.pbThirdTask.progress = 0
            } else {
                binding.pbThirdTask.progress += 10
            }
        }
    }
}