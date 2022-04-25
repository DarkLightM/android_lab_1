package com.example.profilescreen.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.profilescreen.R

class UserCardAdapter : ListAdapter<UserCard, UserCardAdapter.ViewHolder>(UserButtonDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val infoIcon: ImageView = view.findViewById(R.id.infoIcon)
        private val personInfo: TextView = view.findViewById(R.id.personInfo)
        private val divider: View = view.findViewById(R.id.divider)
        private val context: Context = view.context

        fun bind(userCard: UserCard, isLastItem: Boolean) {
            infoIcon.setImageResource(userCard.icon)
            personInfo.text = userCard.text

            if (isLastItem){
                divider.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], position == (itemCount - 1))
    }

}

class UserButtonDiffCallback : DiffUtil.ItemCallback<UserCard>() {
    override fun areItemsTheSame(oldItem: UserCard, newItem: UserCard): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: UserCard, newItem: UserCard): Boolean = oldItem == newItem
}