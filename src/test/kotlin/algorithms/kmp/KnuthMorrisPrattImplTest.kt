package algorithms.kmp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KnuthMorrisPrattImplTest {

    private val algorithm = KnuthMorrisPrattImpl()

    @Test
    fun computeLSPTable() {
        assertEquals(listOf(0, 0, 1, 2, 3, 1, 1, 2, 0, 0), algorithm.computeLSPTable("ababaaabcd".toList()))
        assertEquals(listOf(0, 0, 1, 2, 3, 0), algorithm.computeLSPTable("ababac".toList()))
        assertEquals(listOf(0, 1, 0, 1, 0), algorithm.computeLSPTable("aabac".toList()))
        assertEquals(listOf(0, 0, 0, 0, 1, 2, 3, 1), algorithm.computeLSPTable("abcdabca".toList()))
        assertEquals(listOf(0, 0, 0, 0, 1, 2, 3, 4, 5), algorithm.computeLSPTable("abcdabcda".toList()))
        assertEquals(listOf(0, 0, 0, 0, 1, 2, 3, 0, 1), algorithm.computeLSPTable("abcdabcea".toList()))
        assertEquals(listOf(0, 0, 0, 1, 2, 0), algorithm.computeLSPTable("cfgcfa".toList()))
        assertEquals(listOf(0, 1, 0, 1, 0, 1, 0), algorithm.computeLSPTable("aabacaz".toList()))
        assertEquals(listOf(0), algorithm.computeLSPTable("a".toList()))
        assertEquals(listOf(0, 1), algorithm.computeLSPTable("aa".toList()))
        assertEquals(listOf(0, 0), algorithm.computeLSPTable("ab".toList()))
    }

    @Test
    fun search() {
        assertEquals(8, algorithm.search("abazacabababac".toList(), "ababac".toList()).get())
        assertEquals(0, algorithm.search("aabaaabacaz".toList(), "aaba".toList()).get())
        assertEquals(4, algorithm.search("aabaaabacaz".toList(), "aabacaz".toList()).get())
        assertEquals(0, algorithm.search("I hope this is a valid text".toList(), "I hope".toList()).get())
        assertEquals(7, algorithm.search("I hope this is a valid text".toList(), "this is a".toList()).get())
        assertEquals(17, algorithm.search("I hope this is a valid text".toList(), "valid text".toList()).get())
        
        assertEquals(true, algorithm.search("I hope this is a valid text".toList(), "error".toList()).isEmpty())
        assertEquals(true, algorithm.search("aabaaabacaz".toList(), "aabacaza".toList()).isEmpty)
        assertEquals(true, algorithm.search("aabaaabacaz".toList(), "abb".toList()).isEmpty)
    }
}