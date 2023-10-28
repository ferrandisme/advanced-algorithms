package algorithms.rabinkarp

import kotlin.math.pow


/**
 * Rabin-Karp Algorithm
 */
class RabinKarp {
    private val prime = 3

    /**
     * learning = 8
     * nin = 3
     */
    fun search(array: CharArray?, pattern: CharArray?): Int {
        if (array == null || pattern == null) return -1
        val n = array.size
        val m = pattern.size
        val lastChar = n - m
        val patternHash = calculateHash(pattern, m)
        var arrayHash = calculateHash(array, m)
        for (i in 0..lastChar) {
            if (patternHash == arrayHash && match(array, pattern, i)) {
                return i
            }
            if (i < lastChar) {
                arrayHash = recalculateHash(arrayHash, array[i], array[i + m], m)
            }
        }
        return -1
    }

    fun match(array: CharArray, pattern: CharArray, index: Int): Boolean {
        for (i in pattern.indices) {
            if (array[index + i] != pattern[i]) return false
        }
        return true
    }

    fun calculateHash(text: CharArray, hashSize: Int): Long {
        var hash: Long = 0
        for (i in 0..<hashSize) {
            hash = (hash + charVal(text[i]) * prime.toDouble().pow(i.toDouble())).toLong()
        }
        return hash
    }

    fun recalculateHash(oldHash: Long, oldChar: Char, newChar: Char, hashSize: Int): Long {
        var hash = oldHash - charVal(oldChar)
        hash /= prime
        hash = (hash + charVal(newChar) * prime.toDouble().pow((hashSize - 1).toDouble())).toLong()
        return hash
    }

    fun charVal(value: Char): Int {
        return value.code - 96
    }
}

