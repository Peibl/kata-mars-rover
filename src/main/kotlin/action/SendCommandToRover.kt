package action

import domain.Plateau
import domain.Rover
import domain.Rovers

class SendCommandToRover(private val rovers: Rovers, private val plateau: Plateau) {
    fun execute(id: Int, command: String): String {
        val rover = rovers.getById(id)

        val candidatePosition = plateau.getNextPosition(rover.position, rover.orientation)
        if (!plateau.existObstacleAt(candidatePosition)) {
            plateau.unregisterObstacleAt(rover.position)
            rover.position = candidatePosition
            plateau.registerObstacleAt(rover.position)
            return getSuccessResponse(rover)
        }
        return getErrorResponse(rover)
    }

    private fun getSuccessResponse(rover: Rover): String {
        return generateResponseBody(rover) + "OK"
    }

    private fun getErrorResponse(rover: Rover): String {
        return generateResponseBody(rover) + "NOK"
    }

    private fun generateResponseBody(rover: Rover) {
        rover.position.x + rover.position.y + rover.orientation
    }
}
