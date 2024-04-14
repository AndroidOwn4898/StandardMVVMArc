package com.example.appunikinterview.network


data class APIError(
        val message: String? = null,
        val code: String? = null,
        var status_code: Int? = null,
        val errors: HashMap<String, List<String>>? = null
)