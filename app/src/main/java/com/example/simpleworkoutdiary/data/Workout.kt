package com.example.simpleworkoutdiary.data

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant


data class Workout(
    var date:Instant = Clock.System.now(),
    var exercise:String = "",
    var sets: Int = 0,
    var reps: Int = 0
)