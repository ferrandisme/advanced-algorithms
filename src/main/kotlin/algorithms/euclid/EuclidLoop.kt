package algorithms.euclid

/**
 * Euclid Algorithm
 * Calculates the GCD A & B (Greatest Common Divisor between two number A and B)
 */
class EuclidLoop : Euclid {

    /**
     *  Implementation with loop
     * 22/6 = 3 rest of 4
     * 6/4 = 1 rest of 2
     * 4/2 = 2 rest of 0
     *
     * number/temp == result rest of divisor
     */
    override fun gcd(numberI: Int, divisorI: Int): Int {
        var number = numberI
        var divisor = divisorI
        while(divisor != 0){
            val temp = divisor
            divisor = (number % divisor)
            number = temp
        }
        return number;
    }

}