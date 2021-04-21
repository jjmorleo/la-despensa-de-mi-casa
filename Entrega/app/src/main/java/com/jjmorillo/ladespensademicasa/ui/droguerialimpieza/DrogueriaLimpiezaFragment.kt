package com.jjmorillo.ladespensademicasa.ui.droguerialimpieza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jjmorillo.ladespensademicasa.databinding.FragmentDrogueriaLimpiezaBinding


class DrogueriaLimpiezaFragment : Fragment() {

    private var _binding: FragmentDrogueriaLimpiezaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDrogueriaLimpiezaBinding.inflate(inflater, container, false)
        val view= binding.root
        // Inflate the layout for this fragment
        return view
    }


}