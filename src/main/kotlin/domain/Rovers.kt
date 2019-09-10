package domain

interface Rovers {
    fun add(rover: Rover)
    fun getById(id: Int): Rover
}
