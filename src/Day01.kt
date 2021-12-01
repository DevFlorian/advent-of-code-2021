fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        var previous : Int? = null
         input.forEach {
             if(previous != null && previous!! < it.toInt()){
                 count++
             }
             previous = it.toInt()
         }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        var previous : Int? = null
        var previousPrevious : Int? = null
        var previousSum : Int? = null
        input.forEach { current ->
            if(previousSum != null && previousSum!! < (previousPrevious!! + previous!! + current.toInt())){
                count++
            }
            previousSum = previousPrevious?.let { it + previous!! + current.toInt()}
            previousPrevious = previous
            previous = current.toInt()
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
