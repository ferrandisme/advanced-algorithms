package algorithms.kmp

interface KnuthMorrisPratt {

    fun computeLSPTable(pattern : List<Char>) : List<Int>
}