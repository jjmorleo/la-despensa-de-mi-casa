package com.jjmorillo.ladespensademicasa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        // Inflate the layout for this fragment
        return view
    }


}