package com.example.fruitsandvegetables.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is an app to Classify Fruits and Vegetables. The model has been trained on a limited number  of fruits and vegetables to demonstrate" +
                "The camera can be accessed by a button at the bottom of this page.Once the camera is opened it sends a continuous stream of images to the prediction model and prints out predictions respectively" +
                "\nJust point the camera towards an image of a fruit or vegetable to get the prediction for it"
    }
    val text: LiveData<String> = _text
}