package org.example

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
            1  -> addMake()
            2  -> addModel()
            3  -> addEngineSize()
            4  -> addYear()
            5  -> noOfBerths()
            6  -> addTransmission()
            7  -> addFuelType()
            8  -> noOfBatteries()
            9  -> runJourneyMenu()
            10 -> deleteVan()
            0  -> exitApp()
            else -> println("Invalid choice: $option")
        }
    } while (true)
}

fun runJourneyMenu() {
    do {
        when (val option = journeyMenu()){
            1 -> startLocation()
            2 -> endLoaction()
            3 -> distance()
            4 -> startDate()
            5 -> rating()
            6 -> daysRented()
            7 -> costPerDay()
            8 -> deleteVan()
            9 -> return
            else -> println("Invalid choice: $option ")
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

