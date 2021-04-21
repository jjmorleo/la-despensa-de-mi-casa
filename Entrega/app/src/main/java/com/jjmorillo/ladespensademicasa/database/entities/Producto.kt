package com.jjmorillo.ladespensademicasa.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "productos")
data class Producto(val nombre: String, val marca: String, val descripcion: String, val imagen: String, val precio_unidad: Double, val precio: Double) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0


    override fun toString(): String {
        return "Producto(nombre='$nombre', marca='$marca', descripcion='$descripcion', imagen='$imagen', precio_unidad=$precio_unidad, precio=$precio)"
    }
}
