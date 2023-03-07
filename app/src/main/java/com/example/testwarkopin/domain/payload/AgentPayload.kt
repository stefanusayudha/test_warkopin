package com.example.testwarkopin.domain.payload

data class AgentPayload(
    val sortInverted: Boolean = false,
    val search: String = "",
    val limit: Int = 10,
    val minSoldItem: Int = 0
)