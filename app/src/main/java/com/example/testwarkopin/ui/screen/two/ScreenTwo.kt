package com.example.testwarkopin.ui.screen.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testwarkopin.databinding.ScreenTwoBinding

class ScreenTwo : Fragment() {

    private lateinit var binding: ScreenTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ScreenTwoBinding
            .inflate(
                inflater,
                container,
                false
            )

        return binding.root
    }
}