package com.example.testwarkopin.data.src.rapid

import com.example.testwarkopin.domain.model.AgentListResponse
import com.example.testwarkopin.domain.model.AgentsItem
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AgentWebSource {
    @GET("agents/list")
    suspend fun getAgentList(
        @QueryMap query: HashMap<String, String>
    ): AgentListResponse
}