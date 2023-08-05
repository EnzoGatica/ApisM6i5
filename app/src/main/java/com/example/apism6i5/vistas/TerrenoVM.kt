package com.example.apism6i5.vistas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apism6i5.data.Repositorio
import com.example.apism6i5.data.local.ItemDataBase
import com.example.apism6i5.data.remote.Terreno
import com.example.apism6i5.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    fun terrenosLiveData() = repositorio.obtenerItems()
    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        val itemBaseDato = ItemDataBase.getDatabase(application).getItemsDao()
        repositorio = Repositorio(api,itemBaseDato)
    }

    fun getAllTerrenos() = viewModelScope.launch {
        repositorio.cargarTerreno()
    }

    fun terrenosLiveData(id:String)  = repositorio.obtenerTerrenosConId(id)

}