package com.jjmorillo.ladespensademicasa.ui.droguerialimpieza

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
import com.jjmorillo.ladespensademicasa.databinding.FragmentDrogueriaLimpiezaBinding
import com.jjmorillo.ladespensademicasa.models.Producto
import com.jjmorillo.ladespensademicasa.viewModels.ProductoViewModel


class DrogueriaLimpiezaFragment : Fragment() {

    private var _binding: FragmentDrogueriaLimpiezaBinding? = null
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDrogueriaLimpiezaBinding.inflate(inflater, container, false)
        val view= binding.root
        auth = Firebase.auth

        val model: ProductoViewModel by viewModels()
        model.obtenerNovedades().observe(viewLifecycleOwner, {
            createRecyclerView(it)
        })
        // Inflate the layout for this fragment
        return view
    }
    private fun createRecyclerView(productos: List<Producto>) {
        //apply es para el patron builder
        val mAdapter = RecyclerViewAdapter(productos as MutableList<Producto>)
        val recyclerView = binding!!.drogueriaLimpiezaRecyclerViewFragment
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