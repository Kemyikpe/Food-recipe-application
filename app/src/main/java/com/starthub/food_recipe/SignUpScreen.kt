package com.starthub.food_recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starthub.food_recipe.databinding.SignUpScreenBinding

class SignUpScreen : AppCompatActivity() {
    private val binding: SignUpScreenBinding by lazy {
        SignUpScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.alreadyHaveAccount.setOnClickListener {
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
        binding.createAccount.setOnClickListener {
            val intent = Intent(this, LocationScreen::class.java)
            startActivity(intent)
        }
    }
}