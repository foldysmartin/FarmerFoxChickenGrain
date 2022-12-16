fun main() {
    val startingState = State(farmer = Position.LEFT, fox = Position.LEFT, chicken = Position.LEFT, grain = Position.LEFT)
    val endState =
        State(farmer = Position.RIGHT, fox = Position.RIGHT, chicken = Position.RIGHT, grain = Position.RIGHT)

    val moves = PathFinder(startingState, endState).findPath()
    println(moves.fold("") { currentString, move -> currentString + move})
}