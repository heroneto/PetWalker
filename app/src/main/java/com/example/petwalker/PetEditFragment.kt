package com.example.petwalker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_petdetails.closeButton
import kotlinx.android.synthetic.main.fragment_petedit.*

class PetEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_petedit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        closeButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petlist_fragment_action)
        }

        updateButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petdetails_fragment_action)
        }
    }

}