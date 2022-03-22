package com.example.profilescreen.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.profilescreen.R

class UserAdapter : ListAdapter<UserInformation, UserAdapter.ViewHolder>(UserDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val infoIcon = view.findViewById<ImageView>(R.id.infoIcon)
        val infoText = view.findViewById<TextView>(R.id.personInfo)
        val underline = view.findViewById<View>(R.id.divider)

        fun bind(userInformation: UserInformation, isLastItem: Boolean) {
            infoIcon.setImageResource(userInformation.imageResource)
            infoText.text = userInformation.infoText

            if (isLastItem){
                underline.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], position == (itemCount - 1))
    }
}

class UserDiffCallback : DiffUtil.ItemCallback<UserInformation>() {
    override fun areItemsTheSame(oldItem: UserInformation, newItem: UserInformation): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserInformation, newItem: UserInformation): Boolean =
        oldItem == newItem
}