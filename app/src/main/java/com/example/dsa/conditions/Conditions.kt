package com.example.dsa.conditions

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
}