package com.example.testwarkopin.ui.screen.three

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testwarkopin.databinding.ScreenThreeBinding

class ScreenThree : Fragment(){

    private lateinit var binding: ScreenThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ScreenThreeBinding
            .inflate(
                inflater,
                container,
                false
            )

        return binding.root
    }
}