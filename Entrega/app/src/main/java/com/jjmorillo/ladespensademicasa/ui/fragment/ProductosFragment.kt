package com.jjmorillo.ladespensademicasa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.adapters.RecyclerViewAdapter
import com.jjmorillo.ladespensademicasa.databinding.FragmentProductosBinding
import com.jjmorillo.ladespensademicasa.models.Producto


class ProductosFragment : Fragment() {

    private var binding: FragmentProductosBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductosBinding.inflate(inflater, container, false)
        val view = binding!!.root

        loadListView()
        createRecyclerView()

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
            //EL RECYCLERVIEW VA A SER UNA LISTA HORIZONTAL
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = mAdapter
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


        productos.add(Producto("galletas dinosaurios", "gullon", "galletas de cereales 250g", "galletas de formato", 1.55, 3.95))
        productos.add(Producto("cereales chocolate", "kollbram", "cereales de chocolate con leche 500g", "cerealessss", 1.22, 2.85))
        productos.add(Producto("cereale integrales sin gluten", "hacendado", "cereales sin gluten 450g ", "tetrtrtrtrt", 0.65, 1.58))
        productos.add(Producto("galletas cookies", "gullon", "galletas de trigo con chocolate 250g", "tetrtrtrtrt", 0.85, 1.85))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))
        productos.add(Producto("nnnnnaa", "gagagag", "gdgdgdgdgdg", "tetrtrtrtrt", 0.95, 1.18))



        return productos


    }
}