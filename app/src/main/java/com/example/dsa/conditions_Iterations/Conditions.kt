package com.example.dsa.conditions_Iterations

import androidx.compose.animation.scaleOut

class ConditionManagement() {

    /**
    two ways of managing conditions in Kotlin
     **/

    fun FindGreaterValue() {
        val a = 10
        val b = 20
        var result: Int = 0

        if (a > b) {
            result = a
        } else {
            result = b
        }
    }

    fun FindGreaterValueWithWhen() {
        val a = 10
        val b = 20
        val result = when {
            a > b -> a
            else -> b
        }
    }

    fun FindMax(FirstNum:Int,SecNum:Int):Int{
        return if(FirstNum>SecNum) FirstNum else SecNum
    }

    /**
    ways of iterating a collection in Kotlin
     **/

    fun IterateData() {

        for (i in 1..5) {
            println(i)
        }
    }

    fun IterateDataWithWhile() {

        val x = 15
        val y = 10

        while (x > y) {
            println(x)
        }

        do {
            println(x)

        } while (x > y)
    }
}