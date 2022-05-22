package com.example.profilescreen.domain.api

class ApiProvider(private val client: RetrofitClient) {
    private val baseUrl = "https://61f5894b62f1e300173c41ba.mockapi.io/"

    fun getApi(): ApiService =
        client.getClient(baseUrl)
            .create(ApiService::class.java)
}