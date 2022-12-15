fun moves() = arrayListOf(
    Moves.Farmer,
    Moves.Fox,
    Moves.Chicken,
    Moves.Grain
)

enum class Moves {
    Farmer {
        override fun toString(): String {
            return "Move Alone"
        }
    },
    Fox {
        override fun toString(): String {
            return "Move With Fox"
        }
    },
    Chicken {
        override fun toString(): String {
            return "Move With Chicken"
        }
    },
    Grain {
        override fun toString(): String {
            return "Move With Grain"
        }
    },
}