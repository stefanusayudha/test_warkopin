package com.example.testwarkopin.data.src

import com.example.testwarkopin.data.src.rapid.AgentWebSource
import com.example.testwarkopin.domain.AgentRepository
import com.example.testwarkopin.domain.model.AgentsItem
import com.example.testwarkopin.domain.payload.AgentPayload

class AgentDataSource(
    private val web: AgentWebSource
) : AgentRepository {
    override suspend fun getAgentList(
        pld: AgentPayload
    ): List<AgentsItem> {
        val agents = web.getAgentList(
            hashMapOf<String, String>().apply {
                put("postal_code", "11234")
                put("offset", "0")
                put("limit", pld.limit.toString())
                put("types", "agent")
                put("sort", "recent_activity_high")
            }
        ).agents?.filterNotNull() ?: listOf()

        return agents.filter {
            it.name
                ?.lowercase()
                ?.contains(
                    pld.search
                )
                ?: false
        }.filter {
            (it.recentlySold?.count ?: 0) >= pld.minSoldItem
        }
    }
}