package com.example.apism6i5.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.OnConflictStrategy

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemTerrenos(item: List<Item>)

    @Query("SELECT * FROM tabla_item order by id ASC")
    fun getAllItems(): LiveData<List<Item>>

    /*
    @Query("SELECT SUM(precio) FROM TABLA_ITEM")
    suspend fun getSumPrecio(): LiveData<List<Item>>
    */

    @Query("DELETE FROM tabla_item")
    suspend fun deleteDatos()
}