package nicestring

fun String.isNice(): Boolean {
    val allConditions = listOf(this.containsDoubleLetter(),
        this.hasThreeVowels(),
        !this.containsBu())
    return allConditions.count { it } > 1
}

fun String.containsDoubleLetter() = this.zipWithNext()
    .any { (first, second) -> first == second }

fun String.hasThreeVowels() = this.count { setOf('a', 'e', 'i', 'o', 'u').contains(it) } > 2

fun String.containsBu() = this.contains("bu") ||
        this.contains("ba") ||
        this.contains("be")