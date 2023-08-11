package com.example.apism6i5.data

import androidx.lifecycle.LiveData
import com.example.apism6i5.data.local.Item
import com.example.apism6i5.data.local.ItemDao
import com.example.apism6i5.data.remote.Terreno
import com.example.apism6i5.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI, private val itemDao: ItemDao) {

    fun obtenerItems(): LiveData<List<Item>> = itemDao.getAllItems()

    suspend fun cargarTerreno() {

        val respuesta = terrenoAPI.getData()

        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let { terrenos ->
                val item = terrenos.map { it.transformar() }
                itemDao.insertItemTerrenos(item)
            }
        }
    }


    fun obtenerTerrenosConId(id: String): LiveData<Item> = itemDao.getTerreno(id)

    /*
    suspend fun cargarTerreno(): List<Terreno> {
        val respuesta = terrenoAPI.getData()
        if(respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }

     */

}