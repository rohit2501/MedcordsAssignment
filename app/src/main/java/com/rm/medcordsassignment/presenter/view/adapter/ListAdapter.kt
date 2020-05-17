package com.rm.medcordsassignment.presenter.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rm.medcordsassignment.R
import com.rm.medcordsassignment.presenter.view.model.ListItem

class ListAdapter(var context: Context, var list: List<ListItem>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var textView: TextView

        init {
            textView = v.findViewById(R.id.list_item_title)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.list_data_item_layout, parent, false)
        return ListViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textView.setText(
            String.format(
                context.getString(R.string.listTitle),
                (position + 1).toString()
            )
        )

        holder.textView.setBackgroundColor(Color.parseColor(list.get(position).color))
    }
}