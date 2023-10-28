package algorithms.rabinkarp


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class RabinKarpTest {
    val algorithm: RabinKarp = RabinKarp()


    @Test
    fun searchTest() {
        assertEquals(3, algorithm.search("acbacc".toCharArray(), "acc".toCharArray()))
        assertEquals(4, algorithm.search("learning".toCharArray(), "nin".toCharArray()))
        assertEquals(-1, algorithm.search("learning".toCharArray(), "nina".toCharArray()))
        assertEquals(0, algorithm.search("learning".toCharArray(), "le".toCharArray()))
        assertEquals(0, algorithm.search("learning".toCharArray(), "l".toCharArray()))
        assertEquals(5, algorithm.search("learning".toCharArray(), "ing".toCharArray()))
        assertEquals(5, algorithm.search("learning".toCharArray(), "in".toCharArray()))
        assertEquals(6, algorithm.search("learning".toCharArray(), "ng".toCharArray()))
        assertEquals(7, algorithm.search("learning".toCharArray(), "g".toCharArray()))
        assertEquals(-1, algorithm.search("learning".toCharArray(), null))
        assertEquals(-1, algorithm.search(null, "ing".toCharArray()))
        assertEquals(-1, algorithm.search(null, null))
    }

    @Test
    fun matchTest() {
        assertTrue(algorithm.match("learning".toCharArray(), "nin".toCharArray(), 4))
        assertTrue(algorithm.match("learning".toCharArray(), "le".toCharArray(), 0))
        assertTrue(algorithm.match("learning".toCharArray(), "g".toCharArray(), 7))
        assertFalse(algorithm.match("learning".toCharArray(), "ing".toCharArray(), 4))
        assertFalse(algorithm.match("learning".toCharArray(), "l".toCharArray(), 1))
    }

    @Test
    fun calculateHashTest() {
        assertEquals(28L, algorithm.calculateHash("acbacc".toCharArray(), 3))
    }

    @Test
    fun recalculateHashTest() {
        assertEquals(18L, algorithm.recalculateHash(28L, 'a', 'a', 3))
    }

    @Test
    fun charValTest() {
        assertEquals(97, 'a'.code)
        assertEquals(1, algorithm.charVal('a'))
    }
}

