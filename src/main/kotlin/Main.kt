fun main() {
    println("Введите слова, разделяя их пробелом:")
    val words = readLine()?.split(" ") ?: listOf()

    val wordGroups = groupWordsByLetters(words)

    println("Сгруппированные слова:")
    for (group in wordGroups) {
        println(group.joinToString(", "))
    }
}

fun groupWordsByLetters(words: List<String>): List<List<String>> {
    val wordGroups = mutableListOf<List<String>>()
    val wordMap = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        val group = wordMap.getOrPut(sortedWord) { mutableListOf() }
        group.add(word)
    }

    for (entry in wordMap) {
        wordGroups.add(entry.value)
    }

    return wordGroups
}