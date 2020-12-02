package advent

import java.io.File

println("\nhello\n")

val parsedInput = parseInput()

println("Total count: ${part1(parsedInput)}")
println("Total count: ${part2(parsedInput)}")

fun part1(inputLines: List<InputLine>): Int {
  var count = 0

  inputLines.forEach {
    var totalLetters = 0

    for (char in it.password) {
      if (char == it.character) totalLetters++
    }

    if (totalLetters >= it.minimum && totalLetters <= it.maximum) count++
  }

  return count
}

fun part2(inputLines: List<InputLine>): Int {
  var count = 0

  inputLines.forEach {
    var totalLetters = 0

    val position1 = it.password[it.minimum - 1]
    val position2 = it.password[it.maximum - 1]

    if (position1 == it.character) totalLetters++
    if (position2 == it.character) totalLetters++

    if (totalLetters % 2 == 1) count++
  }

  return count
}

fun parseInput(): List<InputLine> {
  return File("Day2Input.txt").readLines()
      .map {line ->
        val splitLine = line.split(" ", "-", ": ")

        InputLine(
            minimum = splitLine[0].toInt(),
            maximum = splitLine[1].toInt(),
            character = splitLine[2].single(),
            password = splitLine[3],
        )
      }
}

data class InputLine(
    val minimum: Int,
    val maximum: Int,
    val character: Char,
    val password: String,
) {
  override fun toString(): String = "$minimum-$maximum $character: $password"
}

println("\ngoodbye\n")