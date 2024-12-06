import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input.map { line ->
            val first = line.substringBefore("   ").toInt()
            val second = line.substringAfter("   ").toInt()
            first to second
        }.unzip()

        val sum = left.sorted().zip(right.sorted()).map { (first, second) ->
            abs(first - second)
        }.sum()
        return sum
    }

    fun part2(input: List<String>): Int {
        val (left, right) = input.map { line ->
            val first = line.substringBefore("   ").toInt()
            val second = line.substringAfter("   ").toInt()
            first to second
        }.unzip()
        var sum = 0

        left.forEach { first ->
            var count = 0
            right.map { second ->
                if (first == second) count++
            }
            sum += first * count
        }
        return sum
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
//    part1(input).println()
    part2(input).println()
}
