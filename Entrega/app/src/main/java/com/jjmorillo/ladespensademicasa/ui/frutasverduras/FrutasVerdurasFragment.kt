package com.jjmorillo.ladespensademicasa.ui.frutasverduras

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
import com.jjmorillo.ladespensademicasa.databinding.FragmentFrutasVerdurasBinding
import com.jjmorillo.ladespensademicasa.models.Producto
import com.jjmorillo.ladespensademicasa.viewModels.ProductoViewModel


class FrutasVerdurasFragment : Fragment() {


private var _binding:FragmentFrutasVerdurasBinding?=null
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding= FragmentFrutasVerdurasBinding.inflate(inflater, container, false)
        val view= binding.root
        auth = Firebase.auth

        val model: ProductoViewModel by viewModels()
        model.obtenerofertas().observe(viewLifecycleOwner, {
            createRecyclerView(it)
        })

        // Inflate the layout for this fragment
        return view
    }
    private fun createRecyclerView(productos: List<Producto>) {
        //apply es para el patron builder
        val mAdapter = RecyclerViewAdapter(productos as MutableList<Producto>)
        val recyclerView = binding!!.frutasVerdurasRecyclerViewFragment
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