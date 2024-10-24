package com.treysongrange.plantfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.treysongrange.plantfinalproject.databinding.FragmentAddPlantBinding
import com.treysongrange.plantfinalproject.databinding.FragmentPlantListBinding

class AddPlantFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddPlantBinding.inflate(inflater,container,false)
        val viewModel = PlantCreationViewModel()

        viewModel.done.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigateUp()
            }
        }
        binding.FinishButton.setOnClickListener {
            viewModel.createPlant(binding.nameText.text.toString(),binding.lightText.text.toString(),binding.humidText.text.toString())
        }
        return binding.root
    }
}