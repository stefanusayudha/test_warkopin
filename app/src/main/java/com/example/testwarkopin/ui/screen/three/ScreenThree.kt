package com.example.testwarkopin.ui.screen.three

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testwarkopin.databinding.ScreenThreeBinding
import com.example.testwarkopin.domain.model.AgentsItem
import com.example.testwarkopin.domain.payload.AgentPayload
import com.example.testwarkopin.ui.activity.agent.AgentActivity
import com.example.testwarkopin.ui.adapter.AgentListAdapter
import com.example.testwarkopin.ui.modal.agentfilter.AgentFilterModal
import com.example.testwarkopin.util.DATA
import com.google.gson.Gson
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScreenThree : Fragment() {

    private lateinit var binding: ScreenThreeBinding
    private var filter: AgentPayload = AgentPayload(limit = 50)
    private lateinit var adapter: AgentListAdapter
    private val vm: ScreenThreeViewModel by viewModel()

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

        initUI()
        initAction()
        initObserver()
        return binding.root
    }

    private fun initUI() {
        binding.flipper.displayedChild = 0

        adapter = AgentListAdapter(::goToAgentDetailScreen)
        binding.rv.adapter = adapter
    }

    private fun initObserver() {
        viewLifecycleOwner.lifecycleScope
            .launch {
                vm.agentList.collect(::agentListCollector)
            }
    }

    private fun initAction() {
        binding.refreshButton.setOnClickListener {
            loadData()
        }

        binding.filterButton.setOnClickListener {
            openFilterModal()
        }

        binding.clearButton.setOnClickListener {
            vm.clearList()
        }
    }

    private fun openFilterModal() {
        val modal = AgentFilterModal(filter) { modal, result ->
            filter = result
            loadData()
            modal.dismiss()
        }

        activity?.apply {
            modal.show(
                this.supportFragmentManager,
                "Filter"
            )
        }
    }

    private fun loadData() {
        vm.clearList()
        binding.flipper.displayedChild = 0
        vm.getAgentList(filter)
    }

    private fun agentListCollector(
        list: List<AgentsItem>
    ) {
        adapter.submitList(list.toMutableList())
        binding.flipper.displayedChild = 1
    }

    private fun goToAgentDetailScreen(
        agent: AgentsItem
    ) {
        startActivity(
            with(
                Intent(
                    requireContext(),
                    AgentActivity::class.java
                )
            ) {
                putExtra(DATA, Gson().toJson(agent))
            }
        )
    }
}