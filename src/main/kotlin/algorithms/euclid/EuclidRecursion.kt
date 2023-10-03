package algorithms.euclid

/**
 * Euclid Algorithm
 * Calculates the GCD A & B (Greatest Common Divisor between two number A and B)
 */
class EuclidRecursion : Euclid {

    /**
     * Recursion implementation
     * 22/6 = 3 rest of 4
     * 6/4 = 1 rest of 2
     * 4/2 = 2 rest of 0
     */
    override fun gcd(number: Int, divisor: Int): Int {
        val remaining = number % divisor
        return if(remaining == 0){
            divisor
        } else{
            gcd(divisor, remaining)
        }
    }

}