package com.example.geeks_pro_xml.data

import java.io.Serializable

data class Hero(
    val name: String,
    val description: String,
    val image: String,
) : Serializable
