package com.example.petwalker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PetCreateViewModel : ViewModel() {

    private var mSavePet = MutableLiveData<Boolean>()
    val savePet: LiveData<Boolean> = mSavePet


    fun save(name: String, petOwner: String, petType: String, walkDays: String, walkHours: String){
        println(name)
        println(petOwner)
        println(petType)
        println(walkDays)
        println(walkHours)

    }
}