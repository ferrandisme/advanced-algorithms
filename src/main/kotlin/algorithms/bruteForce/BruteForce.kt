package algorithms.bruteForce

import java.util.*

interface BruteForce {

    fun firstMatch ( values : List<Char>, pattern: List<Char>): Optional<Int>

    fun everyMatch(values: List<Char>, pattern: List<Char>): List<Int>
}