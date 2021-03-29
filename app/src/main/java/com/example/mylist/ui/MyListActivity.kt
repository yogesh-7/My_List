package com.example.mylist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mylist.data.db.entity.Item
import androidx.lifecycle.ViewModelProviders
import com.example.mylist.data.db.ItemDatabase
import com.example.mylist.data.repositories.ItemRepository
import com.example.mylist.ui.MyList.AddDialogListener
import com.example.mylist.ui.MyList.AddItemDialog
import com.example.mylist.ui.MyList.ListViewModel
import com.example.mylist.ui.MyList.ListViewModelFactory
import com.example.mylist.databinding.ActivityMainBinding
import com.example.mylist.other.ListItemAdapter
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MyListActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datbase = ItemDatabase(applicationContext)
        val repository = ItemRepository(datbase)
        val factory = ListViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ListViewModel::class.java)


        val adapter = ListItemAdapter(listOf(), viewModel)


        binding.rvItems.adapter = adapter
        binding.fab.setOnClickListener {
            AddItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: Item) {
                        viewModel.upsert(item)
                    }
                }).show()
        }

        viewModel.getAllShoppingItems().observe(
            this, Observer {
                adapter.items = it
                adapter.notifyDataSetChanged()
            }
        )

    }
}