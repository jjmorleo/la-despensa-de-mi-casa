package com.jjmorillo.ladespensademicasa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.adapters.RecyclerViewAdapter
import com.jjmorillo.ladespensademicasa.databinding.FragmentProductosBinding
import com.jjmorillo.ladespensademicasa.models.Producto
import com.jjmorillo.ladespensademicasa.viewModels.ProductoViewModel


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

        //ESTO SERIA PARA INICIALIZAR EL VIEWMODEL, CUANDO PASEMOS POR EL ONCREATEVIEW, NOS VA A CREAR EL VIEWMODEL
        //val model = ViewModelProvider(this).get(ProductoViewModel::class.java)
        val model: ProductoViewModel by viewModels()
        model.obtenerNovedades().observe(viewLifecycleOwner, {
            createRecyclerView(it)
        })

        //HILOS SECUNDARIOS DE EJECUCION -->Threads destinados a cumplir una misión.CREAR UN HILO ES MUY COSTOSO
        //Y POR ELLO SE CREAN LA CORUTINAS-->ES UN HILO, ES DECIR UN THREAD QUE YA ESTA CREADO

        loadListView()
        //createRecyclerView()

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
     


    }

    private fun createRecyclerView(productos: List<Producto>) {
        //apply es para el patron builder
        val mAdapter = RecyclerViewAdapter(productos as MutableList<Producto>)
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

    /*private fun cargarProductos(): List<Producto> {
        return productos

    }*/
}