var getUserInput = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
var userInput = 0
var winner = false

fun main() {
    menu()
    ticTacToe()
    startPlayerOne()
}

fun list() {
    getUserInput = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
}

fun menu() {
    println("Velkommen til tre-på-rad:\nSkriv inn tallet som tilsvarer ruten du vil velge\nFørste til tre på rad vinner!\n")
    println()
}

//Sjekker om brukerinputet ikke allerede er valgt

fun checker(): Boolean {
    return userInput in 1..9 && getUserInput[userInput - 1] != "X" && getUserInput[userInput - 1] != "O"
}

fun startPlayerOne() {
    list()

    for (number in 1..9) {
        if (number % 2 == 1) {
            roundPlayerOne()
            ticTacToe()
            winner()
            if (winner) {
                println("Spiller 1 vinner!!")
                break
            } else if (number == 9) {
                println("Det ble likt mannen")
            }
            continue
        } else {
            roundPlayerTwo()
            ticTacToe()
            winner()
            if (winner) {
                println("Spiller 2 vinner!!")
                break
            } else if (number == 9) {
                println("Det ble likt mannen")
            }
            continue
        }
    }
    startPlayerTwo()
}

fun startPlayerTwo() {
    list()

    for (number in 1..9) {
        if (number % 2 == 1) {
            roundPlayerTwo()
            ticTacToe()
            winner()
            if (winner) {
                println("Spiller 2 vinner!!\n")
                break
            }
            continue
        } else {
            roundPlayerOne()
            ticTacToe()
            winner()
            if (winner) {
                println("Spiller 1 vinner!!\n")
                break
            }
            continue
        }
    }
    startPlayerOne()
}

fun roundPlayerOne() {
    println("SPILLER 1\n")
    try {
        userInput = readLine()!!.toInt()
        checker()
        if (checker()) {
            getUserInput[userInput - 1] = "X"
        } else {
            println("Skriv inn et gyldig valg")
            roundPlayerOne()
        }
    } catch (e: Exception) {
        println("Skriv inn et gyldig tall mellom 1 og 9")
        roundPlayerOne()
    }
}

fun roundPlayerTwo() {
    println("SPILLER 2\n")
    try {
        userInput = readLine()!!.toInt()
        if (checker()) {
            getUserInput[userInput - 1] = "O"

        } else {
            println("Skriv inn et gyldig valg")
            roundPlayerTwo()
        }
    } catch (e: Exception) {
        println("Skriv inn et gyldig tall mellom 1 og 9")
        roundPlayerTwo()
    }
    checker()
}

//Printer ut brettet
fun ticTacToe() {
    println("| ${getUserInput[0].padEnd(1)} | ${getUserInput[1].padEnd(1)} | ${getUserInput[2].padEnd(1)} |\n")
    println("| ${getUserInput[3].padEnd(1)} | ${getUserInput[4].padEnd(1)} | ${getUserInput[5].padEnd(1)} |\n")
    println("| ${getUserInput[6].padEnd(1)} | ${getUserInput[7].padEnd(1)} | ${getUserInput[8].padEnd(1)} |\n")
    println()
}

//sjekker om de ulike vinnemulighetene
fun winner() {
    winner = false
    when {
        getUserInput[0] == getUserInput[1] && getUserInput[0] == getUserInput[2] -> {
            winnerWinnerChickenDinner()
        }
        getUserInput[3] == getUserInput[4] && getUserInput[3] == getUserInput[5] -> {
            winnerWinnerChickenDinner()
        }
        getUserInput[6] == getUserInput[7] && getUserInput[6] == getUserInput[8] -> {
            winnerWinnerChickenDinner()
        }
        getUserInput[0] == getUserInput[3] && getUserInput[0] == getUserInput[6] -> {
            winnerWinnerChickenDinner()
        }
        getUserInput[1] == getUserInput[4] && getUserInput[1] == getUserInput[7] -> {
            winnerWinnerChickenDinner()
        }
        getUserInput[2] == getUserInput[5] && getUserInput[2] == getUserInput[8] -> {
            winnerWinnerChickenDinner()
        }
        getUserInput[0] == getUserInput[4] && getUserInput[0] == getUserInput[8] -> {
            winnerWinnerChickenDinner()
        }
        getUserInput[6] == getUserInput[4] && getUserInput[6] == getUserInput[2] -> {
            winnerWinnerChickenDinner()
        }
    }
}

fun winnerWinnerChickenDinner() {
    winner = true
}