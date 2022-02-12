package com.strixapps.finalmvvm.Utils

fun String.cutType1(): String {
    val myCuttedString = this.split(" ")
    return (myCuttedString[0])
}

fun String.cutType2(): String {
    val myCuttedString = this.split(" ")
    return (myCuttedString[1])
}