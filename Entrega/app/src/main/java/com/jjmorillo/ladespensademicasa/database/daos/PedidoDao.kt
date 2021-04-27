package com.jjmorillo.ladespensademicasa.database.daos

import androidx.room.*
import com.jjmorillo.ladespensademicasa.database.entities.Pedido
import com.jjmorillo.ladespensademicasa.database.entities.PedidosProductosCrossRef
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import com.jjmorillo.ladespensademicasa.database.entities.relations.PedidoConProductos

@Dao
abstract class PedidoDao : BaseDao<Pedido>() {

    @Query("SELECT * from pedidos")
    abstract suspend fun findAll(): List<Pedido>

    @Transaction
    @Query("SELECT * from pedidos where id=:pedidoId")
    abstract suspend fun findAllByIdWithProductos(pedidoId:Long): PedidoConProductos

    @Insert
    protected abstract suspend fun saveCrossRef(crossRef: PedidosProductosCrossRef)
    suspend fun savePedidoProductos(pedidoId:Long, productos: Map<Producto, Int>){
        productos.forEach {
            saveCrossRef(PedidosProductosCrossRef(pedidoId, it.key.id, it.value))

        }
    }

}