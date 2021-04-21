package com.jjmorillo.ladespensademicasa.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.databinding.ItemProductoCardViewBinding
import com.jjmorillo.ladespensademicasa.models.Producto

class RecyclerViewAdapter(val productos:MutableList<Producto>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private fun eliminarProducto(producto:Producto){
        val pos=productos.indexOf(producto)
        productos.removeAt(pos)
        notifyItemRemoved(pos)
    }
//ESTO SERIA UTULIZANDO EL ITEMPRODUCTORECYCLERVIEW
    //class ViewHolder private constructor(val binding: ItemProductoRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)
    class ViewHolder private constructor(val binding: ItemProductoCardViewBinding, val adapter:RecyclerViewAdapter) : RecyclerView.ViewHolder(binding.root) {

        fun rellenarDatos(producto: Producto) {

           // binding.itemProductoId.text = producto.id.toString()
            binding.itemProductoNombre.text = producto.nombre
            binding.itemProductoMarca.text = producto.marca
            binding.itemProductoDescripcion.text = producto.descripcion
            binding.itemProductoPrecioUnidad.text = binding.root.context.getString(R.string.precio_unidad_kilo, producto.precio_unidad)
            binding.productoPrecio.text= binding.root.context.getString(R.string.comprar_product, producto.precio)
            Glide
                .with(binding.root.context)
                .load(producto.imagen)
                .centerCrop()
                .into(binding.productImg)

            binding.productoEliminar.setOnClickListener {
                adapter.eliminarProducto(producto)
            }

        }


        //Se crea un constructor que seria un companion object que lo que haria seria crear un objeto de la clase
        //El companion object es lo mismo que crear una funcion estatica en Java
        companion object {
            fun crearViewHolder(parent: ViewGroup, adapter: RecyclerViewAdapter): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductoCardViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, adapter)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder.crearViewHolder(parent,this)
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