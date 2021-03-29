package com.example.mylist.data.repositories


import com.example.mylist.data.db.entity.Item
import com.example.mylist.data.db.ItemDatabase

class ItemRepository(
    private val db:ItemDatabase
) {

    suspend fun upsert(item: Item) = db.getItemDao().upsert(item)

    suspend fun delete(item: Item) = db.getItemDao().delete(item)

    fun getAllItems() =db.getItemDao().getAllItems()
}