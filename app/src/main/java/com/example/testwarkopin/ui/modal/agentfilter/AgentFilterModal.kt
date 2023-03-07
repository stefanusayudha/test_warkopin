package com.example.testwarkopin.ui.modal.agentfilter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
import com.example.testwarkopin.databinding.LayoutAgentFilterBinding
import com.example.testwarkopin.domain.payload.AgentPayload
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.Slider
import com.google.android.material.slider.Slider.OnSliderTouchListener

class AgentFilterModal(
    private val preConfiguration: AgentPayload,
    private val onApply: (AgentFilterModal, AgentPayload) -> Unit
) : BottomSheetDialogFragment() {

    private lateinit var binding: LayoutAgentFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutAgentFilterBinding
            .inflate(
                layoutInflater,
                container,
                false
            )

        initUI()
        return binding.root
    }

    private fun initUI() {
        binding.slider.valueFrom = 0f
        binding.slider.valueTo = 100f

        binding.slider.value =
            preConfiguration.minSoldItem.toFloat()

        binding.slider.addOnSliderTouchListener(
            object : OnSliderTouchListener {
                @SuppressLint("RestrictedApi")
                override fun onStartTrackingTouch(slider: Slider) {

                }

                @SuppressLint("RestrictedApi")
                override fun onStopTrackingTouch(slider: Slider) {
                    binding.minimumPoint.text = "Minimum Point : ${slider.value.toInt()}"
                }

            }
        )

        binding.btnApply.setOnClickListener {
            onApply.invoke(
                this,
                preConfiguration.copy(
                    minSoldItem = binding.slider.value.toInt()
                )
            )
        }
    }
}