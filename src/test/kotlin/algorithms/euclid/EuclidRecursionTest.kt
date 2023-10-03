package algorithms.euclid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.random.Random

class EuclidRecursionTest{

    private val algorithm = EuclidRecursion()
    @Test
    fun gcd(){
        assertEquals(2, algorithm.gcd(10,2))
        assertEquals(2, algorithm.gcd(22,6))
        assertEquals(4, algorithm.gcd(20,4))
    }

    @Test
    fun random(){
        val a = Random.nextLong(2,1000)
        val b = Random.nextLong(500,100000)
        val b1 = BigInteger.valueOf(a)
        val b2 = BigInteger.valueOf(b)
        println(a.toString() + " - " + b.toString() + " | " + (b1.gcd(b2)))
        assertEquals(b1.gcd(b2).toInt(), algorithm.gcd(a.toInt(),b.toInt()))
    }
}