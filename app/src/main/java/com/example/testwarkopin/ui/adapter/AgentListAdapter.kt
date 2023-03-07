package com.example.testwarkopin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.testwarkopin.R
import com.example.testwarkopin.databinding.ItemAgentBinding
import com.example.testwarkopin.databinding.ItemUserBinding
import com.example.testwarkopin.domain.model.AgentsItem
import com.example.testwarkopin.util.DummyDiffer

class AgentListAdapter : ListAdapter<AgentsItem, AgentListAdapter.Holder>(DummyDiffer()) {

    inner class Holder(
        binding: ItemAgentBinding
    ) : ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): Holder {
        return Holder(
            ItemAgentBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: Holder, position: Int
    ) {
        val data = currentList[position]
        val binding = ItemAgentBinding.bind(holder.itemView)

        if (data.photo?.href.isNullOrBlank())
            binding.img.setImageResource(R.drawable.ic_singularity_logo)
        else
            Glide.with(binding.root.context)
                .load(data.photo?.href)
                .placeholder(R.drawable.ic_singularity_logo)
                .into(binding.img)

        binding.name.text = data.name
        binding.desc.text = data.description
    }
}

