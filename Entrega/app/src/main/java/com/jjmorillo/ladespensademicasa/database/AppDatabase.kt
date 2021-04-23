package com.jjmorillo.ladespensademicasa.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjmorillo.ladespensademicasa.database.daos.UsuarioDao
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import com.jjmorillo.ladespensademicasa.database.entities.Usuario


@Database(entities = arrayOf(Usuario::class, Producto::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao //ESTO ES UNA FUNCION ABSTRACTA Y VA A DEVOLVER UN UsuarioDAO y se llama usuarioDao()

}
