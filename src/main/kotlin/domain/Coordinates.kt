package domain


class Coordinates(val x: Int, var y: Int) {
    constructor() : this(0, 0) {
        var x = (1..10).shuffled().first()
        var y = (1..10).shuffled().first()
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Coordinates

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    fun nextPositionToNorth(): Coordinates {
        y += 1
        return Coordinates(x, y)
    }
}
