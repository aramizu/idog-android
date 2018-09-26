package br.com.aramizu.idog.models

data class User(
        val token: String,
        val userName: String = "Rafael Aramizu Gomes",
        val email: String = "rafael.aramizu@gmail.com"
)