package com.jjmorillo.ladespensademicasa.models

data class Producto(
    val nombre: String,
    val marca: String,
    val descripcion: String,
    val imagen: String,
    val precio_unidad: Double,
    val precio: Double
) {
    var id: Long = -1

    constructor(
        id: Long,
        nombre: String,
        marca: String,
        descripcion: String,
        imagen: String,
        precio_unidad: Double,
        precio: Double
    ) : this(nombre, marca, descripcion, imagen, precio_unidad, precio) {
        this.id = id

    }

    override fun toString(): String {
        return "Producto(id=$id, nombre=$nombre, marca=$marca, descripcion=$descripcion, imagen=$imagen, precio_unidad=$precio_unidad, precio=$precio)"
    }


}
