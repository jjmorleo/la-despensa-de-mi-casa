package com.jjmorillo.ladespensademicasa.ui.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.jjmorillo.ladespensademicasa.application.App
import com.jjmorillo.ladespensademicasa.database.AppDatabase
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import com.jjmorillo.ladespensademicasa.database.entities.Tornillo
import com.jjmorillo.ladespensademicasa.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ESTO SERIA PARA GUARDAR DATOS DESDE EL MAINACTIVITY
        /*val tornillo = Tornillo("juanjo", "hierro", "tornillo de acero cabeza plana","aaaa",12.30, 50.20 )
        val producto = Producto("juanjo", "hierro", "tornillo de acero cabeza plana","aaaa",12.30, 50.20 )

        val db= AppDatabase.newInstance(this)// ESTO E PARA INSTANCIAR, CREAR LA BASE DEDATOS*/
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                App.obtenerDB().mainDao().init()
            }
        }
    }

}