package com.example.apism6i5.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_item")
data class Item(
    @PrimaryKey val id: String,
    val precio: Int,
    val tipo: String,
    val img: String
)