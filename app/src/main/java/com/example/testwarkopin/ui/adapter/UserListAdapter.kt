package com.example.testwarkopin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testwarkopin.databinding.ItemUserBinding
import com.example.testwarkopin.domain.model.User
import com.example.testwarkopin.util.DummyDiffer

class UserListAdapter : ListAdapter<User, UserListAdapter.Holder>(DummyDiffer()) {

    inner class Holder(
        binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {
        return Holder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: Holder,
        position: Int
    ) {
        val data = currentList[position]
        val binding = ItemUserBinding.bind(holder.itemView)

        binding.name.text = data.name
        binding.email.text = data.email
    }
}