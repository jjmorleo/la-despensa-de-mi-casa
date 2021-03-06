package com.jjmorillo.ladespensademicasa.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "usuarios")
data class Usuario(val nombre: String, val email: String, val password: String,val  firebaseUID:String):BaseEntity() {



    override fun toString(): String {
        return "Usuario(nombre='$nombre', email='$email', password='$password')"
    }
}
