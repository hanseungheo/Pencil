package com.hanseungheon.pencil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var items: List<Person>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ItemViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recyclerview, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ItemViewHolder, position: Int) {
        holder.name.text = items[position].name
//        if (items[position].gender==0){
//            holder.gender.setImageResource(R.drawable.ic_man)
//        }
//        else if (items[position].gender==1){
//            holder.gender.setImageResource(R.drawable.ic_pregnant_woman)
//        }
//        else {
//            holder.gender.setImageResource(R.drawable.ic_android)
//        }
//
//        holder.gender.setImageResource(
//            if (items[position].gender == 0) {
//                R.drawable.ic_man
//            } else if (items[position].gender == 1) {
//                R.drawable.ic_pregnant_woman
//            } else {
//                R.drawable.ic_android
//            }
//        )

        holder.gender.setImageResource(
            when (items[position].gender) {
                0 -> R.drawable.ic_man
                1 -> R.drawable.ic_pregnant_woman
                else -> R.drawable.ic_android
            }
        )

//        holder.alive.setImageResource(
//            when (items[position].isAlive) {
//                true-> R.drawable.ic_check
//                false->R.drawable.ic_dead
//            }
//        )

        holder.alive.setImageResource(if (items[position].isAlive) R.drawable.ic_check else R.drawable.ic_dead)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val gender: ImageView = itemView.findViewById(R.id.gender)
        val alive : ImageView = itemView.findViewById(R.id.alive)
    }
}