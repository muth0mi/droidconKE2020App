package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Speaker
import kotlinx.android.synthetic.main.home_item_speaker.view.*

class SpeakerAdapter(private var onSpeakerClickedEvent: (Speaker) -> Unit) :
    ListAdapter<Speaker, RecyclerView.ViewHolder>(SpeakerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_item_speaker, parent, false)
        return SpeakerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val speaker = getItem(position)
        speaker?.let { (holder as SpeakerViewHolder).bindSpeaker(it) }
    }

    inner class SpeakerViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindSpeaker(speaker: Speaker) {
            with(speaker) {
                view.speakerImg.load(imageUrl)
                view.name.text = name
                itemView.setOnClickListener { onSpeakerClickedEvent.invoke(this) }
            }
        }
    }

    class SpeakerDiffCallback : DiffUtil.ItemCallback<Speaker>() {

        override fun areItemsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
            return oldItem == newItem
        }
    }
}