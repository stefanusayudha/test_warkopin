package com.example.testwarkopin.domain.payload

data class AgentPayload(
    val sortInverted: Boolean = false,
    val search: String = "",
    val limit: Int = 20,
    val minSoldItem: Int = 0
)