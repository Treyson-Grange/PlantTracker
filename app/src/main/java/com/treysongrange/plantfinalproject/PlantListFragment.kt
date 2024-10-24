package com.treysongrange.plantfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.treysongrange.plantfinalproject.databinding.FragmentPlantListBinding
import com.treysongrange.plantfinalproject.databinding.PlantListItemBinding

class PlantListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPlantListBinding.inflate(inflater,container,false)
        val viewModel = PlantViewModel()
        binding.PlantRecycler.adapter = PlantAdapter(viewModel.plants)
        binding.PlantRecycler.layoutManager = LinearLayoutManager(context)

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_plantListFragment_to_addPlantFragment)
        }
        return binding.root;
    }
}