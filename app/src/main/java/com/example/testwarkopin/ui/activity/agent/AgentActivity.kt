package com.example.testwarkopin.ui.activity.agent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.testwarkopin.R
import com.example.testwarkopin.data.raw.UserRaw
import com.example.testwarkopin.databinding.ActivityAgentBinding
import com.example.testwarkopin.domain.model.AgentsItem
import com.example.testwarkopin.util.DATA
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AgentActivity : AppCompatActivity(), AgentActivityContract {

    private lateinit var binding: ActivityAgentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupContentView()

        initData()
    }

    private fun setupBinding() {
        binding = ActivityAgentBinding
            .inflate(
                layoutInflater
            )
    }

    private fun setupContentView() {
        val view = binding.root
        setContentView(view)
    }

    private fun initData() {
        val data: AgentsItem? = intent
            .getStringExtra(DATA)
            ?.run {
                val agentTypeToken = object : TypeToken<AgentsItem>() {}.type
                Gson().fromJson(this, agentTypeToken)
            }

        binding.name.text = data?.name
        binding.desc.text = data?.description

        if (data?.photo?.href.isNullOrBlank())
            binding.img.setImageResource(R.drawable.ic_singularity_logo)
        else
            Glide.with(binding.root.context)
                .load(data?.photo?.href)
                .placeholder(R.drawable.ic_singularity_logo)
                .into(binding.img)
    }

}