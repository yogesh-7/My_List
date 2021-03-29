package com.example.mylist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mylist.data.db.entity.Item


@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item : Item)



    @Delete
    suspend fun delete(item: Item)



    @Query("SELECT * FROM MyItems")
   fun getAllItems(): LiveData<List<Item>>
}