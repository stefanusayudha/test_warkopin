package com.example.testwarkopin.data.src

import com.example.testwarkopin.data.src.rapid.AgentWebSource
import com.example.testwarkopin.domain.AgentRepository
import com.example.testwarkopin.domain.model.AgentsItem

class AgentDataSource(
    private val web: AgentWebSource
) : AgentRepository {
    override suspend fun getAgentList(): List<AgentsItem> {
        return web.getAgentList(
            hashMapOf<String, String>().apply {
                put("postal_code", "11234")
                put("offset", "0")
                put("limit", "20")
                put("types", "agent")
                put("sort", "recent_activity_high")
            }
        ).agents?.filterNotNull() ?: listOf()
    }
}