package com.example.w4_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by nampham on 4/17/21.
 */
class IdolAdapter : ListAdapter<Idol, IdolAdapter.ViewHolder>(IdolDiffUtilCallback()) {

    interface IdolAdapterListener{
        fun onClickItem(idol: Idol)
    }
    var listener : IdolAdapterListener? = null

    class IdolDiffUtilCallback : DiffUtil.ItemCallback<Idol>(){
        override fun areItemsTheSame(oldItem: Idol, newItem: Idol): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Idol, newItem: Idol): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener)
    }

    class ViewHolder private constructor(val itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val imgAvatar = itemView.findViewById<ImageView>(R.id.imageView)

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                var view = layoutInflater.inflate(R.layout.idol_item_view, parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(item: Idol, listener: IdolAdapterListener?) {
            tvTitle.text = item.name
            tvDescription.text = item.job
            imgAvatar.setImageResource(item.avatar)
            itemView.setOnClickListener {
                listener?.onClickItem(item)
            }
        }
    }

}