package com.jjmorillo.ladespensademicasa.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.databinding.ActivityMainBinding
import com.jjmorillo.ladespensademicasa.ui.fragment.ProductosFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val fragment = supportFragmentManager //Esto es lo ultimo añadido
        val intent = Intent(this, ProductosFragment::class.java)
        startActivity(intent)
    }
}