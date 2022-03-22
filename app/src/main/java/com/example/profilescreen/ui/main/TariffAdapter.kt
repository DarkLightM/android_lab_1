package com.example.profilescreen.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profilescreen.R

class TariffAdapter :
    ListAdapter<TariffInformation, TariffAdapter.ViewHolder>(TariffDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tariffName = view.findViewById<TextView>(R.id.tariffName)
        val tariffSpeed = view.findViewById<TextView>(R.id.tariffDescription)
        val tariffPrice = view.findViewById<TextView>(R.id.price)
        val underline = view.findViewById<View>(R.id.divider)

        fun bind(tariffInformation: TariffInformation, isLastItem: Boolean) {
            tariffName.text = tariffInformation.tariffName
            tariffSpeed.text = tariffInformation.tariffSpeed
            tariffPrice.text = tariffInformation.tariffCost

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

class TariffDiffCallback : DiffUtil.ItemCallback<TariffInformation>() {
    override fun areItemsTheSame(oldItem: TariffInformation, newItem: TariffInformation): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: TariffInformation,
        newItem: TariffInformation
    ): Boolean = oldItem == newItem
}