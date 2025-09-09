package com.solera.resources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(
    private val characters: List<Rick>
) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView = view.findViewById(R.id.imgRick)
        val name: TextView = view.findViewById(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row = position / 2 // Calculate row
        val column = position % 2 // Calculate column
        holder.itemView.tag = Pair(row, column)

        holder.itemView.setOnClickListener {
            val (row, column) = it.tag as Pair<*, *>
            Toast.makeText(it.context, "Row: $row, Column: $column", Toast.LENGTH_SHORT).show()
        }

        val character = characters[position]
        holder.name.text = character.rickName
        holder.imgView.setImageResource(character.rickImage)
    }

    override fun getItemCount(): Int = characters.size
}