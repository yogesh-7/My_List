package com.example.mylist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mylist.data.db.entity.Item


@Database(
    entities = [Item::class],
    version = 1
)
abstract class ItemDatabase:RoomDatabase() {


    abstract fun getItemDao(): ItemDao


    companion object{

        private val LOCK =Any()

        @Volatile
        private var instance : ItemDatabase?= null


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabse(context).also {
                instance = it
        }
        }

        private fun createDatabse(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ItemDatabase::class.java,"ItemDB.db").build()
    }

}