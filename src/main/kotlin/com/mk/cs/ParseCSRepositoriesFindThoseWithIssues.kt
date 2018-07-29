package com.mk.cs

import com.beust.klaxon.Klaxon


fun main(args: Array<String>) {
    Klaxon().parse(File("src/main/res"))
}