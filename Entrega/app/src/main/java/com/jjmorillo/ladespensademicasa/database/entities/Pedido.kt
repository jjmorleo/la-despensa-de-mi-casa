package com.jjmorillo.ladespensademicasa.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity(tableName = "pedidos")
data class Pedido (val fechaCompra:Date, @ColumnInfo(name = "usuario_id") val usuarioId:Long):BaseEntity(){

    var fechaPedido: Date= Date(System.currentTimeMillis())


}
