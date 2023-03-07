package com.example.testwarkopin.util

import androidx.recyclerview.widget.DiffUtil
import com.example.testwarkopin.domain.model.User


class DummyDiffer<T> : DiffUtil.ItemCallback<T>(){
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return false
    }

}