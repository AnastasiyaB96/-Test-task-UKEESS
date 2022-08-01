package com.belaia.anastasia.testtaskukeess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belaia.anastasia.testtaskukeess.data.PersonModel
import com.bumptech.glide.Glide

class EventsAdapter(private val eventsList: List<PersonModel>) :
    RecyclerView.Adapter<EventsAdapter.EventsViewHolder>() {
    class EventsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTV)
        val genderTextView: TextView = itemView.findViewById(R.id.genderTV)
        val aboutTextView: TextView = itemView.findViewById(R.id.aboutTV)
        val birtTextView: TextView = itemView.findViewById(R.id.birthTV)
        val deathTextView: TextView = itemView.findViewById(R.id.deathTV)
        val pictureImageView: ImageView = itemView.findViewById(R.id.pictureIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return EventsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val item = eventsList[position]
        holder.nameTextView.text = "Name: ${item.name}"
        holder.genderTextView.text = "Gender: ${item.gender}"
        holder.aboutTextView.text = "About: ${item.about}"
        holder.birtTextView.text =
            "Birth data: ${item.birth.date}\nBirth location: ${item.birth.location.name}"
        item.death?.let {
            holder.deathTextView.visibility = View.VISIBLE
            holder.deathTextView.text =
                "Death data: ${it.date}\nDeath location: ${it.location.name}"
        } ?: run {
            holder.deathTextView.visibility = View.GONE
        }

        Glide.with(holder.pictureImageView.context)
            .load(item.picture)
            .into(holder.pictureImageView)
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }
}