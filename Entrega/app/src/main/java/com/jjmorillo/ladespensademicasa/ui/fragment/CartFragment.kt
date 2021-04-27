package com.jjmorillo.ladespensademicasa.ui.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jjmorillo.ladespensademicasa.adapters.CartRecyclerViewAdapter
import com.jjmorillo.ladespensademicasa.adapters.ProductosRecyclerViewAdapter
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import com.jjmorillo.ladespensademicasa.databinding.FragmentCartBinding
import com.jjmorillo.ladespensademicasa.viewModels.CarritoViewModel


class CartFragment : Fragment(), ProductosRecyclerViewAdapter.ProductosAdapterListener {
    private var _binding: FragmentCartBinding? = null
    val modelCarrito: CarritoViewModel by activityViewModels()
    private lateinit var mAdapter: CartRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val binding = _binding!!
        val view = binding.root


        binding.cartPagarMb.setOnClickListener {
            val prefs= activity?.getPreferences(Context.MODE_PRIVATE)
            val userId= prefs!!.getLong("idusuario", -1)
            modelCarrito.savePedido(usuarioId = userId)
        }
        binding.totalTextView.text= modelCarrito.calcularTotalCarrito().toString()



        modelCarrito.obtenerProductos().observe(viewLifecycleOwner, {
            createRecyclerView(it)
        })
        // Inflate the layout for this fragment
        return view
    }




    private fun createRecyclerView(productos: Map<Producto, Int>) {
        //apply es para el patron builder
        mAdapter = CartRecyclerViewAdapter(productos, modelCarrito)
        val recyclerView = _binding!!.cartRecyclerView
        recyclerView.apply {
            //EL RECYCLERVIEW VA A SER UNA LISTA VERTICAL
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
            //PARA AÑADIR LINEAS VERTICALES Y HORIZONTALES
            //addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            //addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL))

        }
    }

    override fun verDetalle(producto: Producto) {

    }

    override fun verCart(producto: Producto) {

    }

}