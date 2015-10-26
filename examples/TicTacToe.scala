// TicTacToe.scala
import com.atomicscala.AtomicTest._

class Cell {
  var entry = ' '
  def set(e:Char):String = {
    if(entry==' ' && (e=='X' || e=='O')) {
      entry = e
      "successful move"
    } else
      "invalid move"
  }
}

class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )

  def printGameBoard(): String = {
    var board = ""
    for (row <- 0 to 2)
      for (column <- 0 to 3) {
        if (column < 3)
          board += cells(row)(column).entry
        else
          board += "\n"
      }
    board
  }

  def checkIfWinOrDrawFor(team:Char): Boolean = {
    var isWinOrDraw = false

    for (row <- 0 to 2)
      if (cells(row)(0).entry == 'X' && cells(row)(1).entry == 'X' && cells(row)(2).entry == 'X')
        isWinOrDraw = true
    else if (cells(row)(0).entry == 'Y' && cells(row)(1).entry == 'Y' && cells(row)(2).entry == 'Y')
        isWinOrDraw = true

    for (column <- 0 to 2)
      if (cells(0)(column).entry == 'X' && cells(1)(column).entry == 'X' && cells(2)(column).entry == 'X')
        isWinOrDraw = true
    else if (cells(0)(column).entry == 'Y' && cells(1)(column).entry == 'Y' && cells(2)(column).entry == 'Y')
        isWinOrDraw = true

   if (cells(0)(0).entry == 'X' && cells(1)(1).entry == 'X' && cells(2)(2).entry == 'X')
        isWinOrDraw = true
    else if (cells(0)(0).entry == 'Y' && cells(1)(1).entry == 'Y' && cells(2)(2).entry == 'Y')
        isWinOrDraw = true

    if (isWinOrDraw) println("WINNER!")
    isWinOrDraw
  }

  def play(e:Char, x:Int, y:Int):String = {
    if(x < 0 || x > 2 || y < 0 || y > 2)
      "invalid move"
    else {
      val move = cells(x)(y).set(e)
      println(printGameBoard)
      val winOrDraw = checkIfWinOrDrawFor('X')
      move
    }
  }
}

val grid = new Grid
//grid.play('X', 1, 1) is "successful move"
//grid.play('X', 1, 1) is "invalid move"
//grid.play('O', 1, 3) is "invalid move"
grid.play('X', 1, 1)
grid.play('O', 0, 0)
grid.play('X', 2, 2)
//grid.play('X', 1, 1)
//grid.play('X', 1, 1)
//grid.play('X', 1, 1)

