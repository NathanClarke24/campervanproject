package org.example

data class Journeys(
    var startLocation: String = "",
    var endLocation: String = "",
    var distance: String = "",
    var startDate: Int = 0,
    var rating: Int = 0,
    var daysRented: Int = 0,
    var costPerDay: Int = 0
)