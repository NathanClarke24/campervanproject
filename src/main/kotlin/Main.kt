package org.example
import org.example.models.CamperVan
import org.example.models.Journeys

fun main() {

val vans = ArrayList<CamperVan>()
var currentVan = CamperVan()
val journeys = ArrayList<Journeys> ()
var currentJourney = Journeys()



    fun mainMenu() = readNextInt(
        """
        ----------------------------------
                 Camper Van Rental
        ----------------------------------

        | Select Van
        ----------------------------------
        |  1) Select the make
        |  2) Select the model
        |  3) Select the Engine Size
        |  4) Select the Year 
        |  5) Select the number of Berths
        |  6) Select the transmission
        |  7) Select the fuel type
        |  8) Select the number of Leisure batteries
        |  
        |  9) Input Journeys
        ----------------------------------

        0) Exit
    """.trimMargin(prefix = "|")
    )


    fun journeyMenu() = readNextInt(
        """
        ----------------------------------
                 Input Journeys
        ----------------------------------

        | Input details
        ----------------------------------
        |  1) Enter start location
        |  2) Enter end location
        |  3) Enter distance Traveled 
        |  4) Enter date that journey started
        |  5) Enter the rating of the condition
        |       when the van was returned (1-5)
        |  6) How many days was it rented for?
        |  7) Enter the cost per day
        ----------------------------------

        0) Exit
    """.trimMargin(prefix = "|")
    )


    fun runMenu() {
        do {
            when (val option = mainMenu()) {

                1 -> currentVan.make = readNextLine("Enter make: ")
                2 -> currentVan.model = readNextLine("Enter model: ")
                3 -> currentVan.engineSize = readNextLine("Enter engine size: ")
                4 -> currentVan.year = readNextInt("Enter year: ")
                5 -> currentVan.berths = readNextInt("Enter berths: ")
                6 -> currentVan.transmission = readNextLine("Enter transmission: ")
                7 -> currentVan.fuelType = readNextLine("Enter fuel type: ")
                8 -> currentVan.leisureBatteries = readNextInt("Enter leisure batteries: ")

                9 -> runJourneyMenu()

                10 -> {
                    vans.add(currentVan)
                    println("Van saved!")
                    currentVan = CamperVan()
                }

                0 -> {
                    println("Exiting program...")
                    return
                }

                else -> println("Invalid choice: $option")
            }
        } while (true)
    }

    fun runJourneyMenu() {
        do {
            when (val option = journeyMenu()) {
                1 -> currentJourney.startLocation = readNextLine("Enter start location: ")
                2 -> currentJourney.endLocation = readNextLine("Enter end location: ")
                3 -> currentJourney.distance = readNextLine("Enter distance travelled: ")
                4 -> currentJourney.startDate = readNextInt("Enter start date: ")
                5 -> currentJourney.rating = readNextInt("Enter rating (1–5): ")
                6 -> currentJourney.daysRented = readNextInt("Enter days rented: ")
                7 -> currentJourney.costPerDay = readNextInt("Enter cost per day: ")
                8 -> {
                    journeys.add(currentJourney)
                    println("Journey saved!")
                    currentJourney = Journeys()
                }
                0 -> return
                else -> println("Invalid choice.")
            }
        } while (true)
    }

    fun addMake() {
        print("Enter make: ")
        currentVan.make = readln()
    }

    fun addModel() {
        print("Enter model: ")
        currentVan.model = readln()
    }

    fun addEngineSize() {
        print("Enter engine size: ")
        currentVan.engineSize = readln()
    }

    fun addYear() {
        print("Enter year: ")
        currentVan.year = readln().toInt()
    }

    fun noOfBerths() {
        print("Enter number of berths: ")
        currentVan.berths = readln().toInt()
    }

    fun addTransmission() {
        print("Enter transmission type: ")
        currentVan.transmission = readln()
    }

    fun addFuelType() {
        print("Enter fuel type: ")
        currentVan.fuelType = readln()
    }

    fun noOfBatteries() {
        print("Enter number of leisure batteries: ")
        currentVan.leisureBatteries = readln().toInt()

    }

    fun addStartLocation() {
        print("Enter your starting location: ")
        currentJourney.startLocation = readln()

    }

    fun addEndLocation() {
        println("Enter your end location: ")
        currentJourney.endLocation = readln()
    }

    fun addDistance() {
        println("Enter how far you traveled: ")
        currentJourney.distance = readln()
    }

    fun addStartDate() {
        println("Enter the date that you started: ")
        currentJourney.startDate = readln().toInt()
    }

    fun addRating() {
        println("Enter the rating you will give for the condition of the journey: ")
        currentJourney.rating = readln().toInt()
    }

    fun addDaysRented() {
        println("How many days did you rent the van for: ")
        currentJourney.daysRented = readln().toInt()
    }

    fun addCostPerDay() {
        println("How much did the van cost you per day: ")
        currentJourney.costPerDay = readln().toInt()
    }
}

fun addItemToNote() {
    val note: Note? = askUserToChooseActiveNote()
    if (note != null) {
        note.addItem(
            Item(
                itemContents = readNextLine(prompt = "\t Item Contents: ")
            )
        )
        println("Add Successful!")
    } else {
        println("Add NOT Successful")
    }
}
