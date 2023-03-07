package com.example.testwarkopin.ui.screen.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testwarkopin.databinding.ScreenOneBinding
import com.example.testwarkopin.domain.model.User
import com.example.testwarkopin.ui.adapter.UserListAdapter
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScreenOne : Fragment(), OnClickListener {

    private lateinit var binding: ScreenOneBinding
    private val vm: ScreenOneViewModel by viewModel()
    private lateinit var adapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScreenOneBinding.inflate(
            inflater,
            container,
            false
        )

        initUI()
        initAction()
        initObserver()
        return binding.root
    }

    private fun initUI() {
        adapter = UserListAdapter()
        binding.rv.adapter =  adapter
    }

    private fun initAction() {
        binding.refreshButton.setOnClickListener(this)
        binding.clearButton.setOnClickListener(this)
    }

    private fun initObserver() {
        viewLifecycleOwner.lifecycleScope
            .launch {
                vm.userListState.collect(::userListCollector)
            }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.refreshButton -> getUserList()
            binding.clearButton -> clearList()
        }
    }

    private fun getUserList() {
        vm.getUserList()
    }

    private fun clearList() {
        vm.clearUserList()
    }

    private fun userListCollector(list: List<User>) {
        adapter.submitList(list.toMutableList())
    }

    override fun onStop() {
        viewLifecycleOwner.lifecycleScope.cancel()
        super.onStop()
    }
}