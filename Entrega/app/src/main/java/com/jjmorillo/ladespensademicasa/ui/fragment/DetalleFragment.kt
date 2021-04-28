package com.jjmorillo.ladespensademicasa.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.database.entities.Producto

import com.jjmorillo.ladespensademicasa.databinding.FragmentDetalleBinding


class DetalleFragment : Fragment() {
    private var _binding: FragmentDetalleBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalleBinding.inflate(inflater, container, false)
        val binding = _binding!!
        val view = binding.root
        val producto= arguments?.getParcelable<Producto>("data")
        binding.detalleNombreTextView.text= producto?.nombre
        binding.detalleDescripcionTextView.text= producto?.descripcion
        binding.detalleDescripcionTextView.text= binding.root.context.getString(R.string.comprar_product, producto?.precio)
        binding.detalleDescripcionTextView.text= producto?.precio_unidad.toString()
        Glide
            .with(binding.root.context)
            .load(producto?.imagen)
            .centerCrop()
            .into(binding.detalleImagenFragment)


        Log.d("PRODUCTO", producto.toString())
        // Inflate the layout for this fragment
        return view
    }


}