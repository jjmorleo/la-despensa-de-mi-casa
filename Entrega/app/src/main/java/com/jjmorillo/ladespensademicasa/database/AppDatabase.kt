package com.jjmorillo.ladespensademicasa.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jjmorillo.ladespensademicasa.application.App
import com.jjmorillo.ladespensademicasa.database.daos.ProductoDao
import com.jjmorillo.ladespensademicasa.database.daos.UsuarioDao
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import com.jjmorillo.ladespensademicasa.database.entities.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Database(entities = arrayOf(Usuario::class, Producto::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao //ESTO ES UNA FUNCION ABSTRACTA Y VA A DEVOLVER UN UsuarioDAO y se llama usuarioDao()
    abstract fun productoDao(): ProductoDao

    companion object {
        private var instance: AppDatabase? = null
        private const val NAME_DB = "La despensa de mi casa"

        fun newInstance(context: Context): AppDatabase {

            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, NAME_DB).build()
            }
            return instance!!

        }

        private val callback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                GlobalScope.launch {
                    //INSERCION DE DATOS
                    withContext(Dispatchers.IO) {
                        App.obtenerDB().usuarioDao().save(Usuario("Álvaro", "a@a.com", "1"))
                       // App.obtenerDB().productoDao().saveAll(insertProductos())
                    }
                }

            }
        }

       /* private fun insertProductos(): List<Producto> {

            val productos = mutableListOf<Producto>()


        }*/


    }


}
