package com.jjmorillo.ladespensademicasa.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjmorillo.ladespensademicasa.databinding.ItemProductoRecyclerViewBinding
import com.jjmorillo.ladespensademicasa.models.Producto

class RecyclerViewAdapter(val productos:List<Producto>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    class ViewHolder private constructor(val binding: ItemProductoRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun rellenarDatos(producto: Producto) {

            binding.itemProductoId.text = producto.id.toString()
            binding.itemProductoNombre.text = producto.nombre
            binding.itemProductoMarca.text = producto.marca
            binding.itemProductoDescripcion.text = producto.descripcion
            binding.itemProductoImagen.text = producto.imagen
            binding.itemProductoPrecioUnidad.text = producto.precio_unidad.toString()
            binding.itemProductoPrecio.text = producto.precio.toString()
            binding.itemProductoId1.text = producto.id.toString()
            binding.itemProductoNombre1.text = producto.nombre
            binding.itemProductoMarca1.text = producto.marca
            binding.itemProductoDescripcion1.text = producto.descripcion
            binding.itemProductoImagen1.text = producto.imagen
            binding.itemProductoPrecioUnidad1.text = producto.precio_unidad.toString()
            binding.itemProductoPrecio1.text = producto.precio.toString()
        }


        //Se crea un constructor que seria un companion object que lo que haria seria crear un objeto de la clase
        //El companion object es lo mismo que crear una funcion estatica en Java
        companion object {
            fun crearViewHolder(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductoRecyclerViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder.crearViewHolder(parent)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.rellenarDatos(productos[position])
    override fun getItemCount() = productos.size

    //Esto seria en formato Java como si fuera un array
    /* override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.rellenarDatos(productos[position])
     }*/

    /* override fun getItemCount(): Int {
         return productos.size

     }
 */

}