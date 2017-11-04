package co.prandroid.swensoncodingchallenge.Question2

/**
 * Created by dharmakshetri on 10/18/17.
 */
class Anagram {
    fun main(args: Array<String>) {
        val pairs = arrayOf(arrayOf("debit card", "bad credit"), arrayOf("punishment", "nine thumps"), arrayOf("dharma", "radmah"))
        for (pair in pairs) {
            val firstWorld = pair[0]
            val secondWord = pair[1]
            val anagram = permutation(firstWorld, secondWord)
            println("$firstWorld, $secondWord: $anagram")
        }
    }

    fun permutation(firstWorld: String, secondWord: String): Boolean {
        if (firstWorld.length != secondWord.length) return false // Permutations must be same length

        val letters = IntArray(128) // Assumption here is ASCII
        for (i in 0 until firstWorld.length) {
            letters[firstWorld[i].toInt()]++
        }

        for (i in 0 until secondWord.length) {
            letters[secondWord[i].toInt()]--
            if (letters[secondWord[i].toInt()] < 0) {
                return false
            }
        }

        return true // letters array has no negative values, and therefore no positive values either
    }

}