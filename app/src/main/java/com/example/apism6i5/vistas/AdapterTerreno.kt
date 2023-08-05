package com.example.apism6i5.vistas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apism6i5.R
import com.example.apism6i5.data.local.Item
import com.example.apism6i5.data.remote.Terreno
import com.example.apism6i5.databinding.ItemTerrenoBinding

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(item: List<Item>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(item)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding): RecyclerView.ViewHolder(v.root) {
        fun bind(item: Item){
            v.tvType.text = item.tipo
            v.tvPrice.text = item.precio.toString()
            v.imagenTerreno.load(item.img)
            v.cvItem.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("id", item.id)
                bundle.putInt("precio", item.precio)
                bundle.putString("tipo", item.tipo)
                bundle.putString("img", item.img)
                Navigation.findNavController(v.root).navigate(R.id.action_listadoTerrenos_to_detalle_Fragmento, bundle)
            }
        }
    }
}