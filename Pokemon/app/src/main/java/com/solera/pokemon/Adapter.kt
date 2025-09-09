package com.solera.pokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(private val characters: List<Characters>, private val fragmentManager: FragmentManager):RecyclerView.Adapter<Adapter.ViewHolder> (){

    private var filtered: MutableList<Characters> = characters.toMutableList()

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val name : TextView = view.findViewById(R.id.tvName)
        val sprite: ImageView = view.findViewById(R.id.imgPokemon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item,parent,false)

        val sprite: ImageView = view.findViewById(R.id.imgPokemon)
        sprite.setOnClickListener{
            val bottomSheet = BottomSheet()
            bottomSheet.show(fragmentManager, bottomSheet.tag)
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = filtered[position]
        holder.name.text = character.name

        //Sprite
        Glide.with(holder.itemView.context)
            .load(character.spriteUrl)
            .into(holder.sprite)
    }

    override fun getItemCount(): Int = filtered.size

    fun filter(query: String)
    {
        filtered = if(query.isEmpty()) characters.toMutableList()
        else characters.filter { it.name.contains(query, ignoreCase = true)}.toMutableList()
        notifyDataSetChanged()
    }
}