package algorithms.bruteForce

import java.util.*

/**
 * Brute Force Algorithm
 * It will search for a pattern in to an array
 * If the pattern is found, the return will be the first index of the array where the pattern is
 * If no match, it will return Optional.Empty
 */
class BruteForceImpl : BruteForce {

    /**
     *Searches for the pattern into an array and return the index of the first char that matches the pattern
     * if not match is found, it will return an Optional
     * values = abcadef
     * pattern = def -> 4
     */
    override fun firstMatch(values: List<Char>, pattern: List<Char>): Optional<Int> {
        for (v  in 0.. values.size - pattern.size ) {
            var match = true
            for(p in pattern.indices){
                if (values[v + p] != pattern[p]) {
                    match = false
                    break
                }
            }
            if (match) {
                return Optional.of(v)
            }
        }
        return Optional.empty()
    }


    /**
     * Searches for the pattern into an array and return the List of indexes of the elements found (first possition)
     * values = abcadef
     * pattern = def -> 4
     */
    override fun everyMatch(values: List<Char>, pattern: List<Char>): List<Int> {
        val result = ArrayList<Int>((values.size / pattern.size)/5)
        for (v  in 0.. values.size - pattern.size ) {
            var match = true
            for(p in pattern.indices){
                if (values[v + p] != pattern[p]) {
                    match = false
                    break
                }
            }
            if (match) {
                 result.add(v)
            }
        }
        return result;
    }
}