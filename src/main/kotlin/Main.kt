fun main() {
    var state = State(farmer = Position.LEFT, fox = Position.LEFT, chicken = Position.LEFT, grain = Position.LEFT)
    val endState =
        State(farmer = Position.RIGHT, fox = Position.RIGHT, chicken = Position.RIGHT, grain = Position.RIGHT)

    val moves = mutableListOf<Pair<Moves, State>>()
    for (i in 1..100) {
        // If this is shuffled it will sometimes hit a dead end, but I am too lazy to solve it
        val potentialMoves = state.potentialMoves()
            .removePreviouslyVisitedStates(moves)
            .toList()

        val move = potentialMoves.first()
        moves.add(move)
        println(move.first)

        state = potentialMoves.first().second
        if (state == endState) {
            println("Completed in ${moves.size} steps")
            break
        }
    }
}

private fun Map<Moves, State>.removePreviouslyVisitedStates(previousMoves: List<Pair<Moves, State>>) =
    this.filter { (_, futureState) -> previousMoves.all { (_, previousState) -> futureState != previousState } }