package com.example.apism6i5.data

import com.example.apism6i5.data.local.Item
import com.example.apism6i5.data.remote.Terreno
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun transformar() {
        //given/dado)
        val id = "id"
        val precio = 123
        val tipo = "tipo"
        val img = "img"
        val terreno = Terreno(id ,precio,tipo, img)

        //when(cuando)
        val result = terreno.transformar()

        //then(entonces)

        assertEquals(id, result.id)
        assertEquals(precio, result.precio)
        assertEquals(tipo, result.tipo)
        assertEquals(img, result.img)

    }
}