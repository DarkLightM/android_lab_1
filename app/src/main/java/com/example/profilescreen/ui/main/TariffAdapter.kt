package com.example.profilescreen.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profilescreen.R

class TariffAdapter :
    ListAdapter<Tariff, TariffAdapter.ViewHolder>(TariffDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tariffName = view.findViewById<TextView>(R.id.tariffName)
        val tariffSpeed = view.findViewById<TextView>(R.id.tariffDescription)
        val tariffPrice = view.findViewById<TextView>(R.id.price)
        val underline = view.findViewById<View>(R.id.divider)
        private val context: Context = view.context

        fun bind(tariff: Tariff, isLastItem: Boolean) {
            tariffName.text = tariff.name
            tariffPrice.text = context.getString(R.string.money_string_int, tariff.amount.toInt())
            tariffSpeed.text = tariff.description

            if (isLastItem){
                underline.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tarif_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], position == (itemCount - 1))
    }
}

class TariffDiffCallback : DiffUtil.ItemCallback<Tariff>() {
    override fun areItemsTheSame(oldItem: Tariff, newItem: Tariff): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Tariff,
        newItem: Tariff
    ): Boolean = oldItem == newItem
}