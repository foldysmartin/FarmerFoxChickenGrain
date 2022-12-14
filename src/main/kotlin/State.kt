data class State(val farmer: Position, val fox: Position, val chicken: Position, val grain: Position) {
    fun isValid(): Boolean {
      return (!foxEatsChicken() && !chickenEatsTheGrain() && !isDrowning() && !containsInvalidPosition())
    }

    fun potentialMoves(): Map<Moves, State> {
        return moves()
            .map { it to move(it) }
            .filter { it.second.isValid() }.toMap()
    }

    private fun move(move: Moves): State{
        when (move) {
            Moves.FarmerRight -> return this.copy(farmer = this.farmer.moveRight())
            Moves.FarmerLeft -> return this.copy(farmer = this.farmer.moveLeft())
            Moves.FoxRight -> {
                val state = move(Moves.FarmerRight)
                return state.copy(fox = state.fox.moveRight())
            }
            Moves.FoxLeft -> {
                val state = move(Moves.FarmerLeft)
                return state.copy(fox = state.fox.moveLeft())
            }
            Moves.ChickenRight -> {
                val state = move(Moves.FarmerRight)
                return state.copy(chicken = state.chicken.moveRight())
            }
            Moves.ChickenLeft -> {
                val state = move(Moves.FarmerLeft)
                return state.copy(chicken = state.chicken.moveLeft())
            }
            Moves.GrainRight -> {
                val state = move(Moves.FarmerRight)
                return state.copy(grain = state.grain.moveRight())
            }
            Moves.GrainLeft -> {
                val state = move(Moves.FarmerLeft)
                return state.copy(grain = state.grain.moveLeft())
            }
        }
    }

    private fun foxEatsChicken() : Boolean {
        return (fox == chicken) && (fox != farmer)
    }

    private fun chickenEatsTheGrain() : Boolean {
        return (chicken == grain) && (chicken != farmer)
    }

    private fun containsInvalidPosition(): Boolean {
        return farmer.isInvalid() || fox.isInvalid() || chicken.isInvalid() || grain.isInvalid()
    }

    private fun isDrowning() : Boolean {
        return if (farmer != Position.RIVER) {
            itemsInTheRiver() > 0
        }else {
            itemsInTheRiver() > 1
        }
    }

    private fun itemsInTheRiver() : Int {
        return fox.isInRiver().toInt() + chicken.isInRiver().toInt() + grain.isInRiver().toInt()
    }

    private fun Boolean.toInt() = if (this) 1 else 0

}



