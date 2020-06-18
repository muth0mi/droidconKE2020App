package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Organizer
import com.android254.droidconKE2020.home.domain.Sponsor
import kotlinx.android.synthetic.main.home_item_organizer.view.*

class OrganizerAdapter : ListAdapter<Organizer, RecyclerView.ViewHolder>(OrganizerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_item_organizer, parent, false)
        return OrganizerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val organizer = getItem(position)
        organizer?.let { (holder as OrganizerViewHolder).bindOrg(it) }
    }

    inner class OrganizerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orgImg = view.organizerImg

        fun bindOrg(organizer: Organizer) {
            with(organizer) {

            }
        }
    }

    class OrganizerDiffCallback : DiffUtil.ItemCallback<Organizer>() {

        override fun areItemsTheSame(oldItem: Organizer, newItem: Organizer): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: Organizer, newItem: Organizer): Boolean {
            return oldItem == newItem
        }
    }
}