package com.paulo.rickandmorty.domain.utils

import java.text.SimpleDateFormat
import java.util.*

fun converterData(data: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
    val outputFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())

    val parsedDate = inputFormat.parse(data)
    return outputFormat.format(parsedDate)
}
