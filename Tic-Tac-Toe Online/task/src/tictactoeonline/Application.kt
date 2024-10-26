package tictactoeonline

fun main() {

    showPlayerNames()
    chooseFieldSize()
    printField(createField(3,3))
    enterMove()
//    print(createField(3, 3))
}


fun showPlayerNames(playerName1: String = "Player1", playerName2: String = "Player2"){
    val player1 = getPlayerName("first", playerName1)
    println("First player's name: $player1")

    val player2 = getPlayerName("second", playerName2)
    println("Second player's name: $player2")
    println()
}

fun getPlayerName(playerNumber: String, defaultName: String): String{
    println("Enter the $playerNumber player's name ($defaultName by default)")
    return readln().ifEmpty { defaultName }
}

fun chooseFieldSize(defaultSizeX: Int = 3, defaultSizeY: Int = 3) {
    println("Enter the field size (3x3 by default):")
    val input = readln().ifEmpty { "${defaultSizeX}x${defaultSizeY}" }
    val sizes = input.split("x").map { it.toIntOrNull() }

    val rows: Int
    val cols: Int

    if (sizes.size == 2 && sizes[0] != null && sizes[1] != null) {
        // Controleer of de waarden geldig zijn en of minstens één waarde >= 3 is
        if (sizes[0]!! >= 3 || sizes[1]!! >= 3) {
            rows = sizes[0]!!
            cols = sizes[1]!!
        } else {
            rows = defaultSizeX
            cols = defaultSizeY
        }
    } else {
        rows = defaultSizeX
        cols = defaultSizeY
    }
    println("Field size: ${rows}x${cols}")
    println()

}

fun printField(field: MutableList<MutableList<String>>) {
    val fieldSizeX = field.size
    val fieldSizeY = field[0].size

    // Print de bovenkant van het speelveld
    print("|---".repeat(fieldSizeY) + "|")
    println("-y")

    // Print elke rij van het speelveld
    for (row in field) {
        println("| " + row.joinToString(" | ") + " |")
        println("|---".repeat(fieldSizeY) + "|")
    }
    println("|")
    print("x")
    println()
}

fun createField(fieldSizeX: Int, fieldSizeY: Int): MutableList<MutableList<String>> {
    // Maak een 2D-lijst aan en vul deze met lege spaties
    return MutableList(fieldSizeX) { MutableList(fieldSizeY) { " " } }
}

fun enterMove(){
    println("Enter Bob's move as (x,y)")
    val move = readln()

}