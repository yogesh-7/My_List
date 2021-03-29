package com.example.mylist.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MyItems")
data class Item (
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int,
        ){
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null
}