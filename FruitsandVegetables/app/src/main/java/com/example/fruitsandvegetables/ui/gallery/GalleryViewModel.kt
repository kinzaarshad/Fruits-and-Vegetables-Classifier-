package com.example.fruitsandvegetables.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "A TensorFlow Lite Model is used in this application whose purpose is to identify the most prominent item in picture out of the categories it has been trained on." +
                "The expected image is 224 * 224 with three channels( red, blue and green) per pixel .Each value in the tensor is a single byte between 0 and 255." +
                "\n the probability against each value shows how much confidence the model has in the guess .The top three are shown for each frame out of a continuous stream"
    }
    val text: LiveData<String> = _text
}