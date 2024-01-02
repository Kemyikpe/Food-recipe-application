package com.starthub.food_recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starthub.food_recipe.databinding.LoginScreenBinding

class LoginScreen : AppCompatActivity() {
    private val binding :LoginScreenBinding by lazy {
        LoginScreenBinding .inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener {
            val intent= Intent(this, SignUpScreen::class.java)
            startActivity(intent)
        }
        binding.dontHaveAccount.setOnClickListener {
            val intent= Intent(this, SignUpScreen::class.java)
            startActivity(intent)
        }
    }
}