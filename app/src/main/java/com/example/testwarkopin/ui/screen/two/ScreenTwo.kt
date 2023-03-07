package com.example.testwarkopin.ui.screen.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testwarkopin.databinding.ScreenTwoBinding
import com.example.testwarkopin.domain.model.AgentsItem
import com.example.testwarkopin.ui.adapter.AgentListAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScreenTwo : Fragment() {

    private lateinit var binding: ScreenTwoBinding
    private val vm: ScreenTwoViewModel by viewModel()
    private lateinit var adapter: AgentListAdapter

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

        initUI()
        initData()
        initAction()
        initObserver()
        return binding.root
    }

    private fun initUI() {
        binding.flipper.displayedChild = 0

        adapter = AgentListAdapter()
        binding.rv.adapter = adapter
    }

    private fun initData() {

    }

    private fun initAction() {
        binding.loadBtn.setOnClickListener{
            vm.clearList()
            binding.flipper.displayedChild = 0
            vm.getAgentList()
        }
    }
    private fun initObserver() {
        viewLifecycleOwner.lifecycleScope
            .launch {
                vm.agentList
                    .collect(::agentListCollector)
            }
    }

    private fun agentListCollector(
        list: List<AgentsItem>
    ) {
        adapter.submitList(list.toMutableList())
        binding.flipper.displayedChild = 1
    }
}