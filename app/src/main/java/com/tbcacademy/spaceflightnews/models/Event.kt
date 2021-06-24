package com.tbcacademy.spaceflightnews.models


import androidx.annotation.Keep

@Keep
data class Event(
    val id: String,
    val provider: String
)