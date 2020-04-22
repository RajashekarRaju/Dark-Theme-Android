package com.developersbreach.darkthemeandroid.view.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.darkthemeandroid.R
import com.developersbreach.darkthemeandroid.model.Sports

class SearchAdapter(
    private val socialList: List<Sports>,
    private val onClickListener: OnClickListener
) :
    ListAdapter<Sports, SearchAdapter.SearchViewHolder>(
        DiffCallback
    ) {

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.search_title_text_view)
        val iconImageView: ImageView = itemView.findViewById(R.id.search_icon_image_view)
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
        val sports: Sports = socialList[position]
        holder.titleTextView.text = sports.title
        holder.iconImageView.setImageResource(sports.icon)

        holder.itemView.setOnClickListener{
            onClickListener.onClick(sports)
        }
    }

    override fun getItemCount() = socialList.size

    class OnClickListener(val clickListener: (sports: Sports) -> Unit) {
        fun onClick(sports: Sports) = clickListener(sports)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Sports>() {
        override fun areItemsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem.title == newItem.title
        }
    }
}