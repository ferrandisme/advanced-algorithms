package algorithms.kmp

import java.util.*

class KnuthMorrisPrattImpl : KnuthMorrisPratt {

    /**
     * Method returns the index for the first match o the pattern into the index
     * It will return Optional empty in case it does not match
     *
     * i
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13
     * a b a z a c a b a b  a  b  a  c
     *
     * a b a b a c
     * 0 0 1 2 3 0
     * j
     *
     * this example return index of 8
     */
    override fun search(array: List<Char>, pattern: List<Char>): Optional<Int> {
        val lsp = computeLSPTable(pattern)
        var j = 0
        for (i in array.indices) {
            while (j > 0 && array[i] != pattern[j]) {
                j = lsp[j - 1]
            }
            if (array[i] == pattern[j]) {
                j++
                if (j == pattern.size) {
                    return Optional.of(i - (pattern.size - 1))
                }
            }
        }
        return Optional.empty()
    }


    /**
     * Computes the table of the longest suffix and longest preffix on the pattern
     * This aims to be used by Knuth-Morris-Pratt algorithm
     */
    override fun computeLSPTable(pattern: List<Char>): List<Int> {
        val lsp = MutableList(pattern.size) { 0 }
        var j = 0
        for (patternIndex in 1..<pattern.size) {
            while (j > 0 && pattern[patternIndex] != pattern[j]) {
                j = lsp[j - 1]
            }
            if (pattern[patternIndex] == pattern[j]) {
                lsp[patternIndex] = j + 1
                j++
            }
        }
        return lsp
    }
}