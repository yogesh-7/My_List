package com.example.mylist.ui.MyList

import com.example.mylist.data.db.entity.Item

interface AddDialogListener {
    fun onAddButtonClicked(item: Item)
}