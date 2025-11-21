package org.example

class queryMenu {
}

fun queryMenu() = readNextInt(
    """
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