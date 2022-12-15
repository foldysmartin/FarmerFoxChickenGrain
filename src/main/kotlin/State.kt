data class State(val farmer: Position, val fox: Position, val chicken: Position, val grain: Position) {
    fun isValid(): Boolean {
        return (!foxEatsChicken() && !chickenEatsTheGrain())
    }

    fun potentialMoves(): Map<Moves, State> {
        if (!isValid()) throw IllegalStateException("State $this is not legal")
        return moves()
            .map { it to move(it) }
            .filter { it.second.isValid() }.toMap()
    }

    private fun move(move: Moves): State {
        return when (move) {
            Moves.Farmer -> this.copy(farmer = this.farmer.move())
            Moves.Fox -> {
                val state = move(Moves.Farmer)
                state.copy(fox = state.fox.move())
            }
            Moves.Chicken -> {
                val state = move(Moves.Farmer)
                state.copy(chicken = state.chicken.move())
            }
            Moves.Grain -> {
                val state = move(Moves.Farmer)
                state.copy(grain = state.grain.move())
            }
        }
    }

    private fun foxEatsChicken(): Boolean {
        return (fox == chicken) && (fox != farmer)
    }

    private fun chickenEatsTheGrain(): Boolean {
        return (chicken == grain) && (chicken != farmer)
    }
}



