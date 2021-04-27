package com.jjmorillo.ladespensademicasa.ui.pescados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.adapters.ProductosRecyclerViewAdapter
import com.jjmorillo.ladespensademicasa.databinding.FragmentPescadosBinding
import com.jjmorillo.ladespensademicasa.database.entities.Producto
import com.jjmorillo.ladespensademicasa.viewModels.CarritoViewModel
import com.jjmorillo.ladespensademicasa.viewModels.ProductoViewModel


class PescadosFragment : Fragment(), ProductosRecyclerViewAdapter.ProductosAdapterListener {
    private var _binding: FragmentPescadosBinding? = null
    val modelCarrito: CarritoViewModel by activityViewModels()
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentPescadosBinding.inflate(inflater, container, false)
        val view= binding.root
        auth = Firebase.auth

        val model: ProductoViewModel by viewModels()
        model.obtenerPescados().observe(viewLifecycleOwner, {
            createRecyclerView(it)
        })
        // Inflate the layout for this fragment
        return view
    }
    private fun createRecyclerView(productos: List<Producto>) {
        //apply es para el patron builder
        val mAdapter = ProductosRecyclerViewAdapter(productos as MutableList<Producto>, modelCarrito, this, CarritoViewModel())
        val recyclerView = binding!!.pescadosRecyclerViewFragment
        recyclerView.apply {
            //EL RECYCLERVIEW VA A SER UNA LISTA VERTICAL
            //layoutManager = GridLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
            //PARA AÑADIR LINEAS VERTICALES Y HORIZONTALES
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL))

        }
    }
    override fun verDetalle(producto: Producto) {

        NavHostFragment.findNavController(this).navigate(R.id.action_to_detalleFragment)
    }

    override fun verCart(producto: Producto) {
        NavHostFragment.findNavController(this).navigate(R.id.action_to_mobile_cartFragment)
    }

}