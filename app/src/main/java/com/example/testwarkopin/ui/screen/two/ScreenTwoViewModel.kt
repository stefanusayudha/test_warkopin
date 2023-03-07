package com.example.testwarkopin.ui.screen.two

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwarkopin.domain.AgentRepository
import com.example.testwarkopin.domain.model.AgentsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScreenTwoViewModel(
    private val repo: AgentRepository
) : ViewModel() {

    private val _agentListState = MutableStateFlow<List<AgentsItem>>(listOf())
    val agentList: StateFlow<List<AgentsItem>>
        get() = _agentListState

    fun getAgentList() {
        viewModelScope.launch {
            val data = repo.getAgentList()
            _agentListState.emit(data)
        }
    }

    fun clearList() {
        viewModelScope.launch {
            _agentListState.emit(listOf())
        }
    }
}