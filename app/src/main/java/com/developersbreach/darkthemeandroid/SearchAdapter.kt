package com.developersbreach.darkthemeandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(
    private val socialList: List<Social>
) :
    ListAdapter<Social, SearchAdapter.SearchViewHolder>(
        DiffCallback
    ) {

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.search_title_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_search,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val social: Social = socialList[position]
        holder.titleTextView.text = social.title
    }

    override fun getItemCount() = socialList.size

    companion object DiffCallback : DiffUtil.ItemCallback<Social>() {
        override fun areItemsTheSame(oldItem: Social, newItem: Social): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Social, newItem: Social): Boolean {
            return oldItem.title == newItem.title
        }
    }
}