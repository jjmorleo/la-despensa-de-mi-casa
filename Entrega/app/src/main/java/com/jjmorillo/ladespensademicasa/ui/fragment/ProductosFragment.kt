package com.jjmorillo.ladespensademicasa.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.adapters.RecyclerViewAdapter
import com.jjmorillo.ladespensademicasa.databinding.FragmentProductosBinding
import com.jjmorillo.ladespensademicasa.models.Producto


class ProductosFragment : Fragment() {

    private var binding: FragmentProductosBinding? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductosBinding.inflate(inflater, container, false)
        val view = binding!!.root
        auth = Firebase.auth

        loadListView()
        createRecyclerView()

        //  CERRAR SESION

       /* binding.closeSesion.setOnClickListener(){
            auth.signOut()
             NavHostFragment.findNavController(this).navigate(R.id.action_to_loginFragment)
            requireActivity().finish()
        }*/

        return view
    }

    private fun loadListView() {


        /*
        createListView()
        */
        createRecyclerView()


    }

    private fun createRecyclerView() {
        //apply es para el patron builder
        val mAdapter = RecyclerViewAdapter(cargarProductos())
        val recyclerView = binding!!.productosRecyclerViewFragment
        recyclerView.apply {
            //EL RECYCLERVIEW VA A SER UNA LISTA VERTICAL
            //layoutManager = GridLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
            //PARA AÑADIR LINEAS VERTICALES Y HORIZONTALES
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL))

        }
    }

    /*private fun createListView() {
        //CONTEXT
        //LAYOUT DONDE CARGAR LOS DATOS
        //LOS DATOS
        *//*val adapter = ArrayAdapter<Producto>(
                requireContext()
                        android . R . layout . simple_list_item
                        cargarProductos()
        )*//*
        //val adapter = ListViewAdapter(requireContext(), R.layout.item_producto_list_view, cargarProductos())
        //binding!!.productosRecyclerViewFragment.adapter = adapter


    }*/

    private fun cargarProductos(): List<Producto> {

        val productos = mutableListOf<Producto>()


        productos.add(Producto(1, "galletas dinosaurios", "gullon", "galletas de cereales 250 g", "galletas_principe", 1.55, 3.95))
        productos.add(Producto(2, "cereales chocolate", "kollbram", "cereales de chocolate con leche 500 g", "galletas_principe", 1.22, 2.85))
        productos.add(Producto(3, "cereale integrales sin gluten", "hacendado", "cereales sin gluten 450 g ", "galletas_principe", 0.65, 1.58))
        productos.add(Producto(4, "galletas cookies", "gullon", "galletas de trigo con chocolate 250 g", "galletas_principe", 0.85, 1.85))
        productos.add(Producto(5, "estrellas de chocolate", "lu principe", "estrella de galletas de chocolate 150 g", "galletas_principe", 0.95, 1.18))
        productos.add(Producto(6, "galletas oreo original", "mondelez", "pack galletas oreo 154 g", "galletas_principe", 0.33, 1.05))
        productos.add(Producto(7, "galletas de chocolate", "principe", "deliciosas galletas de chocolate 300 g", "galletas_principe", 0.45, 2.40))
        productos.add(Producto(8, "galleta choco flakes", "cuetara", "galletas de choco leche 550 g", "galletas_principe", 0.65, 3.18))
        productos.add(Producto(9, "galleta principe mini", "principe", "galleta de chocolate 160 g", "galletas_principe", 0.55, 2.30))
        productos.add(Producto(10, "galleta chips ahoy", "chips ahoy", "irresistibles con chocolate 125 g", "galletas_principe", 0.70, 1.18))
        productos.add(Producto(11, "galletas con naranja", "flora", "galletas de cereales 160 g", "galletas_principe", 0.45, 1.65))
        productos.add(Producto(12, "galletas de nocilla", "nocilla", "galletas originales de nocilla 120 g", "galletas_principe", 0.85, 2.74))
        productos.add(Producto(13, "galletas de café", "reglero", "café regelo colombianos 260 g", "galletas_principe", 0.95, 3.52))
        productos.add(Producto(14, "galletas bio", "gullón", "bio organic digestive 270 g", "galletas_principe", 0.89, 3.29))



        return productos


    }
}