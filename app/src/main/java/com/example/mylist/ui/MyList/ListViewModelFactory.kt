package com.example.mylist.ui.MyList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mylist.data.repositories.ItemRepository


@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(private val repository: ItemRepository)
    :ViewModelProvider.NewInstanceFactory(){


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}