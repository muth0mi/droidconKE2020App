package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Session
import com.android254.droidconKE2020.home.ui.views.HomeFragmentDirections
import kotlinx.android.synthetic.main.home_item_session.view.*

class SessionAdapter : ListAdapter<Session, RecyclerView.ViewHolder>(SessionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_item_session, parent, false)
        return SessionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val session = getItem(position)
        session?.let { (holder as SessionViewHolder).bindSession(it) }
    }

    inner class SessionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindSession(session: Session) {
            with(session) {
                view.sessionImg.load(imageUrl.toInt()) // ToDo: Remove the int cast upon introducing real data
                view.time.text = time
                view.room.text = room
                view.description.text = description
                view.rootView.setOnClickListener { onSessionClicked(id) }
            }
        }

        private fun onSessionClicked(sessionId: Long) {
            val sessionDetailsAction =
                HomeFragmentDirections.actionHomeFragmentToSessionDetailsFragment(sessionId)
            view.findNavController().navigate(sessionDetailsAction)
        }
    }

    class SessionDiffCallback : DiffUtil.ItemCallback<Session>() {

        override fun areItemsTheSame(oldItem: Session, newItem: Session): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Session, newItem: Session): Boolean {
            return oldItem == newItem
        }
    }
}