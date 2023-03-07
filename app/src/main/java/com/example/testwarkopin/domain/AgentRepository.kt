package com.example.testwarkopin.domain

import com.example.testwarkopin.domain.model.AgentsItem

interface AgentRepository {
    suspend fun getAgentList(): List<AgentsItem>
}