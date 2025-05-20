package com.example.flybook

object Flyghts {
    var flyght_name: MutableList<flyght> = mutableListOf(
            flyght(0,"Canada","Moscow","13:12","adada", 5999
        ),
            flyght(1,"Cbanada","Modscow","13:14","adaddaa", 4999)
    )
}
data class flyght (
    val id: Int,
    val departure: String,
    val arrival: String,
    val date_flight: String,
    val company: String,
    val price: Int
)