package com.example.testwarkopin.util

import androidx.recyclerview.widget.DiffUtil
import com.example.testwarkopin.domain.model.User


object DummyDiffer : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return false
    }

    override fun areContentsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return false
    }

}