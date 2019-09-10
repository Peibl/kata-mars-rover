import domain.Rover
import domain.Rovers

class RoversInMemory: Rovers {
    private val rovers = mutableListOf<Rover>()

    override fun add(rover: Rover) {
        rovers.add(rover)
    }

    override fun getById(id: Int): Rover {
        return rovers.find { it.id == id }!!
    }
}
