package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable

class MovieListActivity(var name: String? = null, var watched: Boolean = false, var id: Int): Serializable
