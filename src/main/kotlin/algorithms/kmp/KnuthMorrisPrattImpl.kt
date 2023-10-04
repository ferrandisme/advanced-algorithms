package algorithms.kmp

import kotlin.collections.ArrayList

class KnuthMorrisPrattImpl : KnuthMorrisPratt {

    /**
     * Computes the table of the longest suffix and longest preffix on the pattern
     * This aims to be used by Knuth-Morris-Pratt algorithm
     */
    override fun computeLSPTable(pattern: List<Char>): List<Int> {
        val lsp = ArrayList<Int>(pattern.size)
        var j = 0;
        for( patternIndex in pattern.indices){
            while(j > 0 && pattern[patternIndex] != pattern[j]){
                j = lsp[j-1]
            }
            if(pattern[patternIndex]== pattern[j]){
                lsp[patternIndex] = j + 1
                j++
            }else{
                lsp[patternIndex] = 0
            }
        }
        return lsp
    }
}