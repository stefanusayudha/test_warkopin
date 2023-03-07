package com.example.testwarkopin.ui.screen.three

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwarkopin.domain.AgentRepository
import com.example.testwarkopin.domain.model.AgentsItem
import com.example.testwarkopin.domain.payload.AgentPayload
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScreenThreeViewModel(
    private val repo: AgentRepository
) : ViewModel() {

    private val _agentListState = MutableStateFlow<List<AgentsItem>>(listOf())
    val agentList: StateFlow<List<AgentsItem>>
        get() = _agentListState

    fun getAgentList(pld: AgentPayload) {
        viewModelScope.launch {
            val data = repo.getAgentList(pld)
            _agentListState.emit(data)
        }
    }

    fun clearList() {
        viewModelScope.launch {
            _agentListState.emit(listOf())
        }
    }
}