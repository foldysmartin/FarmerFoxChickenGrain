// Path Finder looks for the first working path that it does not look to find the most optimum path (Not that it matters in this case).
data class PathFinder(
    val currentState: State,
    val endState: State,
    private val path: List<Pair<Moves, State>> = listOf(),
    private val knownStates: Set<State> = setOf(currentState)
) {
    private val potentialMoves = currentState.potentialMoves().removePreviouslyVisitedStates(knownStates)

    fun findPath(): List<Moves> {
        if (currentState == endState) return path.map { it.first }
        return if (potentialMoves.isEmpty()) {
            reverse()
        } else {
            nextStep()
        }
    }

    private fun reverse(): List<Moves> {
        return this.copy(currentState = path.takeLast(2).first().second, path = path.dropLast(1)).findPath()
    }

    private fun nextStep(): List<Moves> {
        val nextMove = potentialMoves.toList().shuffled().first()
        val newPath = path.plus(nextMove)
        return this.copy(
            currentState = nextMove.second,
            path = newPath,
            knownStates = knownStates.plus(nextMove.second)
        ).findPath()
    }
}

private fun Map<Moves, State>.removePreviouslyVisitedStates(previousMoves: Set<State>) =
    this.filter { (_, futureState) -> previousMoves.all { previousState -> futureState != previousState } }