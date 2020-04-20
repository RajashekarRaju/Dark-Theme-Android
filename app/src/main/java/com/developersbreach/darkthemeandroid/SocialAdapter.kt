package com.developersbreach.darkthemeandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SocialAdapter(
    private val socialList: List<Social>,
    private val onClickListener: OnClickListener
) :
    ListAdapter<Social, SocialAdapter.SocialViewHolder>(
        DiffCallback
    ) {

    class SocialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageView: ImageView = itemView.findViewById(R.id.social_item_image_view)
        val titleTextView: TextView = itemView.findViewById(R.id.title_item_text_view)
        val subtitleTextView: TextView = itemView.findViewById(R.id.subtitle_item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocialViewHolder {
        return SocialViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_social,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SocialViewHolder, position: Int) {
        val social: Social = socialList[position]
        holder.iconImageView.setImageResource(social.icon)
        holder.titleTextView.text = social.title
        holder.subtitleTextView.text = social.subtitle

        holder.itemView.setOnClickListener{
            onClickListener.onClick(social)
        }
    }

    override fun getItemCount() = socialList.size

    class OnClickListener(val clickListener: (social: Social) -> Unit) {
        fun onClick(social: Social) = clickListener(social)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Social>() {
        override fun areItemsTheSame(oldItem: Social, newItem: Social): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Social, newItem: Social): Boolean {
            return oldItem.title == newItem.title
        }
    }
}