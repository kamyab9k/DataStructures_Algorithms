package com.example.dsa.binarysearch

import kotlin.math.ceil
import kotlin.math.log2

class BinarySearch() {
    public val SortedNumbers = IntArray(128) { it + 1 }

    fun findItem(target: Int): Pair<Int, Int> {
        var ArrayLow = 0
        var Arrayhigh = SortedNumbers.size - 1
        var StepsCounter = 0
        while (ArrayLow <= Arrayhigh) {
            StepsCounter++
            val ArrayMid = (ArrayLow + Arrayhigh) / 2
            val guess = SortedNumbers[ArrayMid]

            if (guess == target) {
                return Pair(ArrayMid, StepsCounter)

            } else if (guess < target) {
                ArrayLow = ArrayMid + 1

            } else
                Arrayhigh = ArrayMid - 1
        }
        return Pair(-1, StepsCounter)
    }

    // Mathematical worst case: log2(N)
    fun getWorstCase(): Int {
        return ceil(log2(SortedNumbers.size.toDouble())).toInt()
    }
}