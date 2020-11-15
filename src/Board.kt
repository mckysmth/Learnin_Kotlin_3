class Board {

    private var board = arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", " ")




    fun printBoard(){
        println("[${board.get(0)}] [${board.get(1)}] [${board.get(2)}]")
        println("[${board.get(3)}] [${board.get(4)}] [${board.get(5)}]")
        println("[${board.get(6)}] [${board.get(7)}] [${board.get(8)}]")
    }

    fun printBoardWithNum(){
        println("[1] [2] [3]")
        println("[4] [5] [6]")
        println("[7] [8] [9]")

    }

    fun spotIsEmpty(index : Int) : Boolean {
        return board.get(index - 1).equals(" ")
    }

    fun addMove(index : Int, move : String) {
        board.set(index - 1, move)
    }

    fun getWinner() : String {
        var winner = checkHorizontal(0)

        if (winner.equals("#"))
        {
            winner = checkVertical(0)

            if (winner.equals("#"))
            {
                winner = chechdiagnol1(0)
                if (winner.equals("#"))
                {
                    winner = chechdiagnol2(2)
                }
            }
        }

        return winner
    }

    fun getMoves() : Int {
        var moves = 0

        for (tile in board)
        {
            if (!tile.equals(" "))
            {
                moves++
            }
        }

        return moves
    }

    private fun checkHorizontal(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in index..(index+2))
        {
            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(" "))
        {
            return temp;
        }
        else
        {
            if (index < 6)
            {
                return checkHorizontal(index+3)
            }
            else
            {
                return "#"
            }
        }
    }

    private fun checkVertical(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in index..8 step 3)
        {

            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(" "))
        {
            return temp;
        }
        else
        {
            if (index < 2)
            {
                return checkVertical(index + 1)
            }
            else
            {
                return "#"
            }
        }
    }

    private fun chechdiagnol1(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in index..8 step 4)
        {
            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(" "))
        {
            return temp;
        }
        else
        {
            return "#"
        }
    }

    private fun chechdiagnol2(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in 6 downTo 2 step 2)
        {
            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(" "))
        {
            return temp;
        }
        else
        {
            return "#"
        }
    }


}