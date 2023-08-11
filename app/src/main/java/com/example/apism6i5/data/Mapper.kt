package com.example.apism6i5.data

import com.example.apism6i5.data.local.Item
import com.example.apism6i5.data.remote.Terreno

fun Terreno.transformar(): Item = Item(this.id, this.precio, this.tipo, this.img)
