package com.solera.actividad1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter(private val characters: List<Characters>):RecyclerView.Adapter<CharacterAdapter.ViewHolder> (){

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val imageAvatar: ImageView = view.findViewById(R.id.imgAvatar)
        val name : TextView = view.findViewById(R.id.tvName)
        val specie : TextView = view.findViewById(R.id.tvSpecie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.name.text = character.name
        holder.specie.text = character.species

        Glide.with(holder.itemView.context)
            .load(character.image)
            .into(holder.imageAvatar)
    }

    override fun getItemCount(): Int = characters.size
}