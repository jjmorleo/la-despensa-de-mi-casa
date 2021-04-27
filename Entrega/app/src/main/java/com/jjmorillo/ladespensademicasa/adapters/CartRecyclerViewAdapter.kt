package com.jjmorillo.ladespensademicasa.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import com.jjmorillo.ladespensademicasa.databinding.ItemListCompraRecyclerViewBinding
import com.jjmorillo.ladespensademicasa.viewModels.CarritoViewModel
import java.util.AbstractMap

class CartRecyclerViewAdapter(val productos: Map<Producto, Int>, val model: CarritoViewModel) :
    RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder>() {


    //ESTO SERIA UTULIZANDO EL ITEMPRODUCTORECYCLERVIEW
    //class ViewHolder private constructor(val binding: ItemListCompraRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)
    class ViewHolder private constructor(
        val binding: ItemListCompraRecyclerViewBinding,
        val adapterProductos: CartRecyclerViewAdapter
    ) : RecyclerView.ViewHolder(binding.root) {

        fun rellenarDatos(entry: Map.Entry<Producto, Int>) {

            // binding.itemProductoId.text = producto.id.toString()
            binding.cartItemAumentar1.setOnClickListener {
                adapterProductos.model.addProductoToCart(entry.key)
            }
            binding.itemListNombre.text = entry.key.nombre
            binding.itemListPrecio.text = entry.key.precio.toString()
            binding.itemListCantidad.text = entry.value.toString()
            Glide
                .with(binding.root.context)
                .load(entry.key.imagen)
                .centerCrop()
                .into(binding.imageViewList)


        }


        //Se crea un constructor que seria un companion object que lo que haria seria crear un objeto de la clase
        //El companion object es lo mismo que crear una funcion estatica en Java
        companion object {
            fun crearViewHolder(
                parent: ViewGroup,
                adapterProductos: CartRecyclerViewAdapter
            ): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ItemListCompraRecyclerViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, adapterProductos)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.crearViewHolder(parent, this)

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val keys = productos.keys.toList()
        var values = productos.values.toList()
        val entry = AbstractMap.SimpleEntry<Producto, Int>(keys[position], values[position])
        viewHolder.rellenarDatos(entry)



    }

    override fun getItemCount() = productos.keys.size

    //Esto seria en formato Java como si fuera un array
    /* override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.rellenarDatos(productos[position])
     }*/

    /* override fun getItemCount(): Int {
         return productos.size

     }
 */

}