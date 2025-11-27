package org.example

class queryMenu {
}

fun main (array: Array<String>) {
    runMenu()
}    """
        ----------------------------------
                 Query Menu
        ----------------------------------

        | Select a statistic
        ----------------------------------
        |  1) What Berth is the most rented?
        |  2) What Fuel type is the most popular?
        |  3) What is the most popular rating?
        |  4) Does petrol or diesel vans go further distances?
        |  5) What is the most popular amount of days to rent a van?
        ----------------------------------
        0) Exit
    """.trimMargin(prefix = "|")
)

fun runQueryMenu() {
    do {
        when ( val option = queryMenu()) {
            1 -> mostUsedBirth()
            2 -> popularFuel
            3 -> popularRating
            4 -> furthestDistance
            5 -> popularNoOfDays
            else -> ("Invalid option: $option")
        }
    }
}