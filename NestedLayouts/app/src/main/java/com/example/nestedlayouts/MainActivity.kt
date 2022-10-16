package com.example.nestedlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nestedlayouts.databinding.ActivityMainBinding
private const val EMPTY_STRING = ""
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }
    private fun setListener() {
        binding.button.setOnClickListener {
            addNumbersInTextViews()
        }
    }
    private fun addNumbersInTextViews() {
        val currentNumber =
            binding.h1.text.toString().toIntOrNull()
                ?: binding.h2.text.toString().toIntOrNull()
                ?: binding.h3.text.toString().toIntOrNull()
        val valueToSet = currentNumber?.plus(1)

        when {
            binding.h1.text.isNotBlank() -> {
                binding.h2.text = valueToSet.toString()
                binding.v2.text = valueToSet.toString()
                binding.c2.text = valueToSet.toString()
                binding.h1.text = EMPTY_STRING
                binding.v1.text = EMPTY_STRING
                binding.c1.text = EMPTY_STRING
            }
            binding.h2.text.isNotBlank() -> {
                binding.h3.text = valueToSet.toString()
                binding.v3.text = valueToSet.toString()
                binding.c3.text = valueToSet.toString()
                binding.h2.text = EMPTY_STRING
                binding.v2.text = EMPTY_STRING
                binding.c2.text = EMPTY_STRING
            }
            binding.h3.text.isNotBlank() -> {
                binding.h1.text = valueToSet.toString()
                binding.v1.text = valueToSet.toString()
                binding.c1.text = valueToSet.toString()
                binding.h3.text = EMPTY_STRING
                binding.v3.text = EMPTY_STRING
                binding.c3.text = EMPTY_STRING
            }
        }
    }
}