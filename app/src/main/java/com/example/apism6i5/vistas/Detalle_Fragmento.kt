package com.example.apism6i5.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.apism6i5.R
import com.example.apism6i5.databinding.FragmentDetalleFragmentoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"
private const val ARG_PARAM2 = "precio"
private const val ARG_PARAM3 = "tipo"
private const val ARG_PARAM4 = "img"


class Detalle_Fragmento : Fragment() {

    lateinit var binding: FragmentDetalleFragmentoBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Int? = null
    private var param3: String? = null
    private var param4: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleFragmentoBinding.inflate(layoutInflater,container,false)
        binding.txtIdDetalle.text = param1
        binding.txtPrecioDetalle.text = param2.toString()
        binding.txtTipoDetalle.text = param3
        binding.imgDetalle.load(param4)

        return binding.root
    }


}