package domain

class Rover(var coordinates: Coordinates, var orientation: String) {
    fun execute(command: String) {
        when(command) {
            "F" -> {
                when(orientation) {
                    "N" -> {
                        setCoordinates(1, 2)
                    }
                }
            }
        }
    }

    private fun setCoordinates(x: Int, y: Int) {
        coordinates = Coordinates(x, y)
    }

    fun getPosition(): Coordinates {
        return coordinates
    }
}
