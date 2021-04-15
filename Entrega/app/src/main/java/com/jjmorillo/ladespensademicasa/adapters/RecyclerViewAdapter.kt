package com.jjmorillo.ladespensademicasa.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjmorillo.ladespensademicasa.databinding.ItemProductoRecyclerViewBinding
import com.jjmorillo.ladespensademicasa.models.Producto

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder private constructor(val binding: ItemProductoRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun rellenarDatos(producto: Producto){

            binding.itemProducto.Id.text= producto.id.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}