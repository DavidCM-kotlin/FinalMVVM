package com.strixapps.finalmvvm.Utils

fun String.formatID(): String {
    val myFormattedString = this.toInt()
    return String.format("%03d", myFormattedString)
}