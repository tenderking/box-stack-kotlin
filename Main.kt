import kotlin.collections.*

/**
 * Represents a collection of boxes with their associated values and provides methods for
 * finding solutions to box arrangement problems.
 */
data class BoxValues(
    /** A map of box identifiers (e.g., "box1") to their corresponding values (Doubles). */
    val boxValues: Map<String, Double> = mapOf(
        "box1" to 4.0,
        "box2" to 4.9,
        "box3" to 6.0,
        "box4" to 7.2,
        "box5" to 8.3,
        "box6" to 9.5,
        "box7" to 10.5,
        "box8" to 11.3,
        "box9" to 12.5,
        "box10" to 13.6
    )
) {

    /**
     * Calculates the target height, which is the average of all box values.
     *
     * @return The target height as a Double.
     */
    private fun targetHeight(): Double {
        return boxValues.values.sum() / 3
    }

    /**
     * Generates all possible combinations of elements from the given list with the specified length.
     *
     * @param list The list from which to generate combinations.
     * @param length The desired length of each combination.
     * @return A list of lists, where each inner list represents a combination of elements.
     */
    private fun <T> combinations(list: List<T>, length: Int): List<List<T>> {
        if (length == 0) return listOf(emptyList())
        if (list.isEmpty()) return emptyList()
        val head = list.first()
        val tail = list.drop(1)
        val combsWithHead = combinations(tail, length - 1).map { it + head }
        val combsWithoutHead = combinations(tail, length)
        return combsWithHead + combsWithoutHead
    }

    /**
     * Represents a solution with a combination value and the source indices used to achieve it.
     *
     * @property combination The calculated combination value (e.g., sum of box values).
     * @property source The list of box indices used in this combination.
     */
    data class Solution(val combination: Double, val source: List<Int>)

    /**
     * Finds the best solutions where the combination value is within a certain threshold of the target height.
     *
     * @return A list of [Solution] objects representing the best solutions, sorted by their combination values.
     */
    fun findBestSolutions(): List<Solution> {
        val boxIndices = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val threeBoxesList = combinations(boxIndices, 3)
        val fourBoxesList = combinations(boxIndices, 4)
        val solutions = mutableListOf<Solution>()
        val threshold = 3

        for (boxCombo in threeBoxesList) {
            val boxComboOutput = boxCombo.sumOf { boxValues["box$it"]!! }
            if (boxComboOutput in (targetHeight() - threshold)..(targetHeight() + threshold)) {
                solutions.add(Solution("%.3f".format(boxComboOutput).toDouble(), boxCombo))
            }
        }

        for (boxCombo in fourBoxesList) {
            val boxComboOutput = boxCombo.sumOf { boxValues["box$it"]!! }
            if (boxComboOutput in (targetHeight() - threshold)..(targetHeight() + threshold)) {
                solutions.add(Solution("%.3f".format(boxComboOutput).toDouble(), boxCombo))
            }
        }

        return solutions.sortedBy { it.combination }
    }

    /**
     * Finds combinations of solutions that include all box indices from 1 to 10.
     *
     * @return A list of pairs, where each pair contains:
     *   - A list of three Doubles representing the combination values of the three solutions.
     *   - A list of three lists of Ints, representing the box indices used in each solution.
     */
    fun findArraysIncludingAll(): List<Pair<List<Double>, List<List<Int>>>> {
        val boxIndices = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val bestSolutions = findBestSolutions()

        val validCombinations = mutableListOf<Pair<List<Double>, List<List<Int>>>>()

        for (solution1 in bestSolutions) {
            val remainingIndices1 = boxIndices - solution1.source
            for (solution2 in bestSolutions) {
                if (solution2.source != solution1.source && remainingIndices1.containsAll(solution2.source)) {
                    val remainingIndices2 = remainingIndices1 - solution2.source
                    for (solution3 in bestSolutions) {
                        if (solution3.source != solution1.source && solution3.source != solution2.source &&
                            remainingIndices2.containsAll(solution3.source) &&
                            remainingIndices2.size == solution3.source.size
                        ) {

                            validCombinations.add(
                                Pair(
                                    listOf(solution1.combination, solution2.combination, solution3.combination),
                                    listOf(solution1.source, solution2.source, solution3.source)
                                )
                            )
                        }
                    }
                }
            }
        }

        return validCombinations
    }
}

fun main() {
    val boxValues = BoxValues()

    val bestSolutions = boxValues.findBestSolutions()
    bestSolutions.forEach { solution ->
        println("Combination: ${solution.combination}, Source: ${solution.source}")
    }

    val validArrays = boxValues.findArraysIncludingAll()
    val uniqueValidArrays = validArrays.distinctBy { it.first.sorted() }
    uniqueValidArrays.forEach { solution -> println("Valid combinations: $solution") }
}