package infrastructure

import domain.Orientation
import domain.Position
import domain.Rover

class RoverBuilder private constructor() {
    private var id = 1
    private var position = Position(0, 0)
    private var orientation = Orientation.NORTH

    fun id(id: Int): RoverBuilder {
        this.id = id
        return this
    }

    fun position(position: Position): RoverBuilder {
        this.position = position
        return this
    }

    fun orientation(orientation: Orientation): RoverBuilder {
        this.orientation = orientation
        return this
    }

    fun build() = Rover(id, position, orientation)

    companion object {
        fun aRover() = RoverBuilder()
    }
}
