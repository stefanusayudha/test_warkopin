package com.example.testwarkopin.domain

import com.example.testwarkopin.domain.model.AgentsItem
import com.example.testwarkopin.domain.payload.AgentPayload

interface AgentRepository {
    suspend fun getAgentList(
        pld: AgentPayload
    ): List<AgentsItem>
}