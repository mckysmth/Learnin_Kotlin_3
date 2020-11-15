fun main(args : Array<String>) {
//    for (i in 6 downTo 2 step 2) print(i)

    val board = Board()

    val player1 = "X"
    val player2 = "O"

    var isPlayer1 = true
    var isPlaying = true

    var stringInput : String

    while (isPlaying)
    {
        board.printBoardWithNum()
        println()
        board.printBoard()

        if (isPlayer1)
        {
            print("Player 1's turn: ")
        }
        else
        {
            print("Player 2's turn: ")
        }

        stringInput = readLine()!!

        println()
        println()

        if (board.spotIsEmpty(stringInput.toInt()))
        {
            if (isPlayer1)
            {
                board.addMove(stringInput.toInt(), player1)
                isPlayer1 = false
            }
            else
            {
                board.addMove(stringInput.toInt(), player2)
                isPlayer1 = true
            }
        }
        else
        {
            print("Please pick empty spot")
        }

        println()

        var winner = board.getWinner()

        if (!winner.equals("#"))
        {
            board.printBoard()
            if (player1.equals(winner))
            {
                print("Player 1 wins!!!")
            }

            if (player2.equals(winner))
            {
                print("Player 2 wins!!!")
            }

            isPlaying = false
            break

        }

        if (board.getMoves() == 9)
        {
            isPlaying = false
            board.printBoard()
            println("Tie")
        }


    }


}
