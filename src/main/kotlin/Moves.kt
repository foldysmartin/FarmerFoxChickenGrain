fun moves() = arrayListOf(
    Moves.Farmer,
    Moves.Fox,
    Moves.Chicken,
    Moves.Grain
)

enum class Moves {
    Farmer {
        override fun toString(): String {
            return "Move Alone\n"
        }
    },
    Fox {
        override fun toString(): String {
            return "Move With Fox\n"
        }
    },
    Chicken {
        override fun toString(): String {
            return "Move With Chicken\n"
        }
    },
    Grain {
        override fun toString(): String {
            return "Move With Grain\n"
        }
    },
}