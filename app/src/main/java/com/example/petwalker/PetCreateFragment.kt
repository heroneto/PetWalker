package com.example.petwalker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.petwalker.viewmodel.PetCreateViewModel
import kotlinx.android.synthetic.main.fragment_petcreate.*
import kotlinx.android.synthetic.main.fragment_petdetails.closeButton

class PetCreateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_petcreate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        closeButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petlist_fragment_action)
        }

        saveButton.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.navigate_to_petlist_fragment_action)
            val name = "Eddy"
            val owner = "Cinthia"
            val petType = "Cachorro"
            val walkDay = "Segunda"
            val walkHour = "Às 08:00"

            val mViewModel = ViewModelProvider(this).get(PetCreateViewModel::class.java)

            mViewModel.save(name, owner, petType, walkDay, walkHour)

        }
    }




}