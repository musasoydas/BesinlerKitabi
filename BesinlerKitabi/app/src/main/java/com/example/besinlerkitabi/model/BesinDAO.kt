package com.example.besinlerkitabi.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//Data Access Object
@Dao
interface BesinDAO {
    //veri ekleme
    @Insert
    suspend fun insertAll(vararg besin: Besin): List<Long>//besinleri liste halide vereceğiz
    //vararg


    //veri çekme
    @Query("SELECT * FROM besin ")
    suspend fun getAllBesin(): List<Besin>

    @Query("SELECT * FROM besin WHERE uuid=:besinId")
    suspend fun getBesin(besinId: Int): Besin

    // veri silme işlemi
    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()

}