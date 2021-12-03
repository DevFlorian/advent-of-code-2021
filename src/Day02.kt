fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        input.forEach {
            val (direction, value) = it.split(" ")
            when (direction) {
                "forward" -> horizontal += value.toInt()
                "up" -> depth -= value.toInt()
                "down" -> depth += value.toInt()
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        input.forEach {
            val (direction, value) = it.split(" ")
            when (direction) {
                "forward" -> {horizontal += value.toInt(); depth += (aim * value.toInt())}
                "up" -> aim -= value.toInt()
                "down" -> aim += value.toInt()
            }
        }
        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
