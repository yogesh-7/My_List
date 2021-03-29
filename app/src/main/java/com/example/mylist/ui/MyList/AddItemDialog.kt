package com.example.mylist.ui.MyList

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog


import com.example.mylist.data.db.entity.Item
import com.example.mylist.databinding.DialogAddItemBinding
import java.lang.Exception

class AddItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    private lateinit var binding: DialogAddItemBinding;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.dialog_add_item)

        binding.tvAdd.setOnClickListener {
            try {
                val name = binding.etName.text.toString()
                var amount = 0
                amount = binding.etAmount.text.toString().toInt()
                if (name.isNullOrEmpty()) {
                    Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }else{
                    val item = Item(name, amount)
                    addDialogListener.onAddButtonClicked(item)
                    dismiss()
                }



                binding.tvCancel.setOnClickListener {
                    cancel()
                }
            } catch (e: Exception) {

            }

        }
    }
}