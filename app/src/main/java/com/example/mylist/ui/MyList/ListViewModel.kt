package com.example.mylist.ui.MyList

import com.example.mylist.data.db.entity.Item
import androidx.lifecycle.ViewModel
import com.example.mylist.data.repositories.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: ItemRepository
) : ViewModel() {

 fun upsert(item: Item) = CoroutineScope(Dispatchers.Main).launch {
     repository.upsert(item)
 }

    fun delete(item: Item) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }


    fun getAllShoppingItems() = repository.getAllItems()
}