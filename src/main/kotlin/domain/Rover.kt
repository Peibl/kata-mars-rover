package domain

class Rover(val position: Position, var orientation: Orientations) {
    private val forward = "F"
    private val backward = "B"
    private val left = "L"
    private val right = "R"


    fun execute(command: String) {
        when(command) {
            forward -> moveForward()
            backward -> moveBackward()
            left -> turnLeft()
            right -> turnRight()
        }
    }

    private fun moveForward() {
        when(orientation) {
            Orientations.NORTH -> ++position.y
            Orientations.EAST -> ++position.x
            Orientations.SOUTH -> --position.y
            Orientations.WEST -> --position.x

        }
    }

    private fun moveBackward() {
        when(orientation) {
            Orientations.NORTH -> --position.y
            Orientations.EAST -> --position.x
            Orientations.SOUTH -> ++position.y
            Orientations.WEST -> ++position.x
        }
    }

    private fun turnLeft() {
        when(orientation) {
            Orientations.NORTH -> orientation = Orientations.WEST
            Orientations.EAST -> orientation = Orientations.NORTH
            Orientations.SOUTH -> orientation = Orientations.EAST
            Orientations.WEST -> orientation = Orientations.SOUTH
        }
    }

    private fun turnRight() {
        when(orientation) {
            Orientations.NORTH -> orientation = Orientations.EAST
            Orientations.EAST -> orientation = Orientations.SOUTH
            Orientations.SOUTH -> orientation = Orientations.WEST
            Orientations.WEST -> orientation = Orientations.NORTH
        }
    }
}
