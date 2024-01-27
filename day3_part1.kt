import java.io.File

sealed class Position() {
	object TOP_LEFT: Position()
	object TOP: Position()
	object TOP_RIGHT: Position()
	object RIGHT: Position()
	object BOTTOM_RIGHT: Position()
	object BOTTOM: Position()
	object BOTTOM_LEFT: Position()
	object LEFT: Position()
}

fun main() {
	var input: Array<Array<Char>> = arrayOf()
	File("./day3-input.txt").useLines{ line ->
		var inputLine: Array<Char> = arrayOf()
		line.forEachIndexed { row, char ->
			inputLine += char
		}
		input += inputLine
	}
	input.forEach {
		it.forEach{ch ->
			print(ch)
		}
		println("")
	}
}

fun Array<Array<Char>>.isValidIndex(column: Int, row: Int): Boolean {
	val columnSize = this.size
	val rowSize = this[0].size
	println("col = $columnSize row = $rowSize")
	return (!(row  < 0 || column < 0 || row > (rowSize - 1) || column > (columnSize - 1)))
}

fun Array<Array<Char>>.checkNeighborAtPosition(column: Int, row: Int, position: Position): Char? {
	try {
		return when (position) {
			is Position.TOP_LEFT -> this[column - 1][row - 1]
			is Position.TOP -> this[column - 1][row]
			is Position.TOP_RIGHT -> this[column - 1][row + 1]
			is Position.RIGHT -> this[column][row + 1]
			is Position.BOTTOM_RIGHT -> this[column + 1][row + 1]
			is Position.BOTTOM -> this[column + 1][row]
			is Position.BOTTOM_LEFT -> this[column + 1][row - 1]
			is Position.LEFT -> this[column][row - 1]
		}
	} catch (e: Exception) {
		return null
	}
}
