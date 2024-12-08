fun main() {
    fun checkNumber(list: List<Int>, alreadyUnsafe:Boolean): Boolean {
        var unsafe = alreadyUnsafe
        val isUp = if (list[0] < list[1]) true else false
        if (isUp) {
            for (i in 0..<list.lastIndex) {
                val delta = list[i + 1] - list[i]
                if (delta < 1 || 3 < delta) {
                    if (unsafe) return false
                    unsafe = true
                }
            }
        } else {
            for (i in 0..<list.lastIndex) {
                val delta = list[i] - list[i + 1]
                if (delta < 1 || 3 < delta) {
                    if (unsafe) return false
                    unsafe = true
                }
            }
        }
        return true
    }

    /**
     * それぞれのリストに分解して、差分と変化量を比較させる。
     */
    fun part1(input: List<String>): Int {
        // safeなリストの数
        var safe = 0
        input.forEach { row ->
            var values = row.split(" ").map { it.toInt() }
            if (checkNumber(values, true)) safe++
        }
        return safe
    }


    fun part2(input: List<String>): Int {
        // safeなリストの数
        var safe = 0
        input.forEach { row ->
            var values = row.split(" ").map { it.toInt() }
            if (checkNumber(values, false)) safe++
        }
        return safe
    }


    val input = readInput("Day02_test")
//    val input = readInput("Day02")

//    part1(input).println()
    part2(input).println()
}