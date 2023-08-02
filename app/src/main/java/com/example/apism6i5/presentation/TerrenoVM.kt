package com.example.apism6i5.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.apism6i5.data.Repositorio
import com.example.apism6i5.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        repositorio = Repositorio(api)
    }

    fun getAllTerrenos() = viewModelScope.launch {
        repositorio.cargarTerreno()
    }

}