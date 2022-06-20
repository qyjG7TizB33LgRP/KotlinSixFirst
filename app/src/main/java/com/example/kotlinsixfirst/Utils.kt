package com.example.kotlinsixfirst

import android.content.Context
import android.widget.Toast

const val API_KEY = "Text"
const val API_BACK_KEY = "Back_Text"

fun toast(context: Context, message: String) =
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()