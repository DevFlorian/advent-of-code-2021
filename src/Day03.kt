fun main() {
    fun part1(input: List<String>): Int {
        val frequency = input.first().indices.map { column -> input.groupingBy { it[column] }.eachCount()}
        val gamma = frequency.joinToString("") { frequencies ->
            val mostFrequentChar = frequencies
                    .maxByOrNull { it.value }
                    ?.key
                    ?: error("Should find maximum in $frequencies!")
            mostFrequentChar.toString()
        }
        val epsilon = gamma.map { if (it == '1') '0' else '1' }.joinToString("")
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int =
         input.bitwiseFilter(true).toInt(2) * input.bitwiseFilter(false).toInt(2)



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

fun List<String>.bitwiseFilter(keepMostCommon: Boolean): String =
        first().indices.fold(this) { inputs, column ->
            if (inputs.size == 1) inputs else {
                val split = inputs.partition { it[column] == '1' }
                if (keepMostCommon) split.longest() else split.shortest()
            }
        }.first()

fun <T> Pair<List<T>, List<T>>.longest(): List<T> =
        if (first.size >= second.size) first else second

fun <T> Pair<List<T>, List<T>>.shortest(): List<T> =
        if (first.size < second.size) first else second
