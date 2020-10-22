package com.example.passingdatabetweenactivities

import java.io.Serializable

data class PersonDataClass(
    val name : String,
    val age : Int,
    val country : String
) : Serializable