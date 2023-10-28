package algorithms.kmp

import java.util.*

interface KnuthMorrisPratt {

    fun search(array : List<Char>,  pattern: List<Char>) : Optional<Int>

    fun computeLSPTable(pattern: List<Char>): List<Int>
}