package algorithms.bruteForce

import algorithms.euclid.EuclidLoop
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.Optional

class BruteForceImplTest {

    private val algorithm = BruteForceImpl()

    @Test
    fun firstMatch() {
        assertEquals(1, algorithm.firstMatch(listOf('a','b','c','d'), listOf('b','c')).get())
        assertEquals(3, algorithm.firstMatch(listOf('a','b','c','d','e','f','g','ñ','v','d','e','f','r','p','j'), listOf('d','e')).get())
        var text = "This is an examperrorle text for try to find patterns in a texerrort"
        assertEquals(16, algorithm.firstMatch(text.toList(), "error".toList()).get())
        val optional : Optional<Int> = Optional.empty();
        assertEquals(optional, algorithm.firstMatch("Text without problems".toList(), "error".toList()))
    }

    @Test
    fun everyMatch() {
        assertEquals(listOf(1), algorithm.everyMatch(listOf('a','b','c','d'), listOf('b','c')))
        assertEquals(listOf(3,9), algorithm.everyMatch(listOf('a','b','c','d','e','f','g','ñ','v','d','e','f','r','p','j'), listOf('d','e','f')))
        var text = "This is an examperrorle text for try to find patterns in a texerrorerrort end of text"
        assertEquals(listOf(16,62,67), algorithm.everyMatch(text.toList(), "error".toList()))
        assertEquals(listOf<Int>(), algorithm.everyMatch("Text without problems".toList(), "error".toList()))
    }

    @Test
    fun timeMatch() {
        var text = RandomStringUtils.randomNumeric(999999);
        var query = text.substring(150,154);
        var start = System.currentTimeMillis();
        algorithm.everyMatch(text.toList(), query.toList())
        var end = System.currentTimeMillis();
        assertTrue(end - start < 250 , "Start:" + start + " , End" + end)
    }


}