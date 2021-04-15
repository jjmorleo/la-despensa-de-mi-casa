package com.jjmorillo.ladespensademicasa.models

data class Producto(
    val nombre: String,
    val marca: String,
    val descripcion: String,
    val imagen: String,
    val precio_unidad: Double,
    val precio: Double
)
