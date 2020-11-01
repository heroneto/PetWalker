package com.example.petwalker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.petwalker.R.color.inputBackground
import kotlinx.android.synthetic.main.fragment_petdetails.*

class PetDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_petdetails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        closeButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petlist_fragment_action)
        }

        editButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petedit_fragment_action)
        }
    }

}