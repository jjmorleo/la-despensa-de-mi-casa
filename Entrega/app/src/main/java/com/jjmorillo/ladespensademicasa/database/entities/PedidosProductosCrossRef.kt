package com.jjmorillo.ladespensademicasa.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "pedidos_productos", primaryKeys = ["pedido_id","producto_id"])
data class PedidosProductosCrossRef(

    @ColumnInfo(name = "pedido_id") val pedidoId:Long,
    @ColumnInfo(name = "producto_id") val productoId: Long,
    val cantidad: Int
)
