package com.rm.medcordsassignment.presenter.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.rm.medcordsassignment.R

class ButtonAdapter(var context: Context, var listener:IButtonClickListener) :
    RecyclerView.Adapter<ButtonAdapter.ButtonListViewHolder>() {

    class ButtonListViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var button: Button

        init {
            button = v.findViewById(R.id.button)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonListViewHolder {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.button_item_layout, parent, false)
        return ButtonListViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ButtonListViewHolder, position: Int) {
        holder.button.setText(
            String.format(
                context.getString(R.string.buttonText),
                position+1
            )
        )

        holder.button.setOnClickListener(View.OnClickListener { v-> listener.onButtonClick((v as Button).text.toString()) })
    }

    public interface IButtonClickListener{
        fun onButtonClick(text:String)
    }
}