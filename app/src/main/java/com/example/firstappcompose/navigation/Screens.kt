package com.example.firstappcompose.navigation

import kotlinx.serialization.Serializable

@Serializable
data class Login(val errorMsg: String?)

@Serializable
object Contrasenia

@Serializable
object Searcher

@Serializable
data class Profile(val name: String)

@Serializable
data class Detail(val name: String)