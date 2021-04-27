package com.jjmorillo.ladespensademicasa.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity



@Entity(tableName = "productos")
data class Producto(val nombre: String, val marca: String, val descripcion: String, val imagen: String, val precio_unidad: Double, val precio: Double, val categoria:String): BaseEntity(), Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()!!

    ) {
        parcel.readLong()
    }


    override fun toString(): String {
        return "Producto(nombre='$nombre', marca='$marca', descripcion='$descripcion', imagen='$imagen', precio_unidad=$precio_unidad, precio=$precio)"
    }

    override fun describeContents(): Int {
       return 0
    }

    override fun equals(other: Any?): Boolean {

        if (this===other) return true

        if (javaClass!=other?.javaClass) return false

        other as Producto

        if (id!= other.id) return false

        return true
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(marca)
        parcel.writeString(descripcion)
        parcel.writeString(imagen)
        parcel.writeDouble(precio_unidad)
        parcel.writeDouble(precio)
        parcel.writeString(categoria)
        parcel.writeLong(id)
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }
}
