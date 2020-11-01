package com.example.petwalker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_signin.*

class SignInFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signin, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signuplink.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_sigup_fragment_action)
        }

        loginbutton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petlist_fragment_action)
        }

    }

}