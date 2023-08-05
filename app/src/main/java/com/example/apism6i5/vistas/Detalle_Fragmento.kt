package com.example.apism6i5.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.apism6i5.R
import com.example.apism6i5.databinding.FragmentDetalleFragmentoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"


class Detalle_Fragmento : Fragment() {

    private val terrenoVM: TerrenoVM by activityViewModels()
    lateinit var binding: FragmentDetalleFragmentoBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleFragmentoBinding.inflate(layoutInflater,container,false)

        terrenoVM.terrenosLiveData(param1.toString()).observe(viewLifecycleOwner){
            binding.txtIdDetalle.text = it.id
            binding.txtPrecioDetalle.text = it.precio.toString()
            binding.txtTipoDetalle.text = it.tipo
            binding.imgDetalle.load(it.img)
        }

        return binding.root
    }


}