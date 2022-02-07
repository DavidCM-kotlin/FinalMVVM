package com.strixapps.finalmvvm.Utils

fun String.weightConverter(): String {
    val pounds = this.toDouble()
    val kg = pounds / 2.205
    return String.format("%.1f", kg)
}
