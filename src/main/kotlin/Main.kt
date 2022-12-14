fun main(args: Array<String>) {
    var state = State(Position.LEFT, Position.LEFT, Position.LEFT, Position.LEFT);
    val endState = State(Position.RIGHT, Position.RIGHT, Position.RIGHT, Position.RIGHT);
    val moves = mutableListOf<Pair<Moves, State>>()
    for (i in 1..100) {
        // If this is shuffled it will sometimes hit a dead end but I am too lazy to fix that
        val potentialMoves = state.potentialMoves()
            .removePreviouslyVisitedStates(moves)
            .toList()


        state = potentialMoves.first().second;
        moves.add(potentialMoves.first())

        if(state == endState) {
            println("Completed in ${moves.size} steps")
            break
        }
    }

    println(moves)
}

private fun Map<Moves, State>.removePreviouslyVisitedStates(previousMoves: List<Pair<Moves, State>>) = this.filter { (_, futureState) -> previousMoves.all{(_, previousState) -> futureState != previousState} }