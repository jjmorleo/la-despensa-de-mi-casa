package com.jjmorillo.ladespensademicasa.ui.alimentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.adapters.RecyclerViewAdapter
import com.jjmorillo.ladespensademicasa.databinding.FragmentAlimentacionBinding
import com.jjmorillo.ladespensademicasa.models.Producto
import com.jjmorillo.ladespensademicasa.viewModels.ProductoViewModel


class AlimentacionFragment : Fragment() {
    private var _binding: FragmentAlimentacionBinding? = null
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAlimentacionBinding.inflate(inflater, container, false)
        val view = binding.root
        auth = Firebase.auth

        val model: ProductoViewModel by viewModels()
        model.obtenerAlimentacion().observe(viewLifecycleOwner, {
            createRecyclerView(it)
        })
        // Inflate the layout for this fragment
        return view
    }

    private fun createRecyclerView(productos: List<Producto>) {
        //apply es para el patron builder
        val mAdapter = RecyclerViewAdapter(productos as MutableList<Producto>)
        val recyclerView = binding!!.alimentacionRecyclerViewFragment
        recyclerView.apply {
            //EL RECYCLERVIEW VA A SER UNA LISTA VERTICAL
            //layoutManager = GridLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
            //PARA AÑADIR LINEAS VERTICALES Y HORIZONTALES
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL))

        }
    }
}