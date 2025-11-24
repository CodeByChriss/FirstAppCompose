package com.example.firstappcompose.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class Searcher(val name: String)

@Serializable
object Profile

@Serializable
data class Detail(val name: String)