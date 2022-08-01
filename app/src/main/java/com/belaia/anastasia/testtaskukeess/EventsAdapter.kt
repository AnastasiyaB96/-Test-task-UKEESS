package com.belaia.anastasia.testtaskukeess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belaia.anastasia.testtaskukeess.data.PersonModel

class EventsAdapter(val eventsList: List<PersonModel>): RecyclerView.Adapter<EventsAdapter.EventsViewHolder>() {
    inner class EventsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.nameTV)
        val genderTextView: TextView = itemView.findViewById(R.id.genderTV)
        val aboutTextView: TextView = itemView.findViewById(R.id.aboutTV)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return EventsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val item = eventsList[position]
        holder.nameTextView.text =item.name
        holder.genderTextView.text =item.gender
        holder.aboutTextView.text =item.about
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }
}