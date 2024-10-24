package com.treysongrange.plantfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.treysongrange.plantfinalproject.databinding.PlantListItemBinding
import com.treysongrange.plantfinalproject.models.Plant

class PlantAdapter(val plants: ObservableArrayList<Plant>): RecyclerView.Adapter<PlantAdapter.ViewHolder>(){
    class ViewHolder(val binding: PlantListItemBinding): RecyclerView.ViewHolder(binding.root)

    init {
        plants.addOnListChangedCallback(object  : ObservableList.OnListChangedCallback<ObservableArrayList<Plant>>() {
            override fun onChanged(sender: ObservableArrayList<Plant>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(
                sender: ObservableArrayList<Plant>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemChanged(positionStart)
            }

            override fun onItemRangeInserted(
                sender: ObservableArrayList<Plant>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemInserted(positionStart)
            }

            override fun onItemRangeMoved(
                sender: ObservableArrayList<Plant>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {

            }

            override fun onItemRangeRemoved(
                sender: ObservableArrayList<Plant>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemRemoved(positionStart)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlantListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder,position :Int) {
        val plant = plants[position]
        holder.binding.plantName.text = "Name: "  + plant.name
        holder.binding.plantLight.text = "Light Level: " + plant.light
        holder.binding.plantHumid.text = "Humidity Level: " + plant.humid
    }

    override fun getItemCount(): Int {
        return plants.size
    }
}