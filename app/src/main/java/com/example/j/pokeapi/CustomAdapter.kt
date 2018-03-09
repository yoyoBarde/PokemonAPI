package com.example.j.pokeapi

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by Romeo on 3/7/2018.
 */
class CustomAdapter(val pokemonList:ArrayList<PokemonData>,context:Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
var mcontext=context
    override fun getItemCount(): Int {
        return pokemonList.size
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val pokeName = itemView.findViewById<TextView>(R.id.pokeNameTV)
        val pokeImage = itemView.findViewById<ImageView>(R.id.pokeImage)

    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.pokemon_layout,parent,false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val pokemon:PokemonData = pokemonList[position]
        holder?.pokeName?.text = pokemon.pokeName
        val pokemonImage = holder?.pokeImage
        Picasso.with(mcontext).load(pokemon.pokeImage).into(pokemonImage)



    }






}


