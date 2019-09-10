package infrastructure

import domain.Plateau
import domain.Position

class PlateauBuilder private constructor() {
    private var size = 2
    private var obstacles = mutableListOf<Position>()

    fun size(size: Int): PlateauBuilder {
        this.size = size
        return this
    }

    fun obstacles(obstacles: MutableList<Position>): PlateauBuilder {
        this.obstacles = obstacles
        return this
    }

    fun build() = Plateau(size, obstacles)

    companion object {
        fun aPlateau() = PlateauBuilder()
    }
}
