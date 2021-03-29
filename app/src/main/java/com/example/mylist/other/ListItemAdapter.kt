package com.example.mylist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.R
import com.example.mylist.data.db.entity.Item
import com.example.mylist.ui.MyList.ListViewModel
import kotlinx.android.synthetic.main.list_item.view.*

class ListItemAdapter(
    var items: List<Item>,
    private val viewModel: ListViewModel
) : RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder>() {


    inner class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {

        val currentItem = items[position]
        holder.itemView.tvName.text = currentItem.name
        holder.itemView.tvAmount.text = "${currentItem.amount}"

        holder.itemView.ivDelete.setOnClickListener({
            viewModel.delete(currentItem)
        })

        holder.itemView.ivPlus.setOnClickListener({
            currentItem.amount++
            viewModel.upsert(currentItem)
        })

        holder.itemView.ivMinus.setOnClickListener({
            if(currentItem.amount>0){
                currentItem.amount--
                viewModel.upsert(currentItem)
            }
        })


    }

    override fun getItemCount(): Int {
        return items.size
    }
}