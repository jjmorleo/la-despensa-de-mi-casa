package com.jjmorillo.ladespensademicasa.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmorillo.ladespensademicasa.application.App
import com.jjmorillo.ladespensademicasa.database.entities.Pedido
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class CarritoViewModel : ViewModel() {
    private val _productosCompra: MutableLiveData<Map<Producto, Int>> =
        MutableLiveData<Map<Producto, Int>>()

    fun obtenerProductos(): LiveData<Map<Producto, Int>> = _productosCompra
    fun addProductoToCart(producto: Producto) {

        val _productos = _productosCompra.value
        val map = if (_productos == null) {
            mutableMapOf()
        } else {
            _productos as MutableMap<Producto, Int>
        }
        if (map[producto] == null) {
            map[producto] = 1
        } else {
            val cantidad = map[producto]!!
            map[producto] = +1
        }

        var total = 0
        map.forEach { (_, cantidad) ->
            total += cantidad

        }
        _productosCompra.postValue(map)

        //TOTAL DE ITEMS
    }

    fun delProductoFromCart(producto: Producto) {

    }

    fun calcularTotalCarrito(): Double {

        val productos = _productosCompra.value
        var total = 0.0
        productos?.forEach { (producto, cantidad) ->
            total += producto.precio * cantidad

        }
        return total
    }

    fun savePedido(usuarioId: Long) {

        val db = App.obtenerDB()
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val productos = _productosCompra.value
                if (productos != null) {
                    val idPedido = db.pedidoDao().save(Pedido(Date(), usuarioId))
                    db.pedidoDao().savePedidoProductos(idPedido, productos)

                }

            }

        }
    }
}