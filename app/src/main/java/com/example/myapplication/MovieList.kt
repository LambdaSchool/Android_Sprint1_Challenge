package com.example.myapplication

import java.io.Serializable

//initiating the class (there are no objects yet)
data class MovieList(var name: String? = null, var watched: Boolean = false): Serializable
