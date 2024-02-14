import scala.util.boundary
import scala.collection.concurrent.TrieMap
import scalafx.collections.ObservableMap
import scala.collection.mutable
import Components.* 

val game = ChessGame(Board.startBoard())
game.makeMove(Position.fromString("A2"), Position.fromString("A4"))
game.makeMove(Position.fromString("A4"), Position.fromString("A5"))
game.makeMove(Position.fromString("A5"), Position.fromString("A6"))
game.makeMove(Position.fromString("A6"), Position.fromString("B7"))
game.makeMove(Position.fromString("B7"), Position.fromString("C8"))
game.makeMove(Position.fromString("g1"), Position.fromString("f3"))
game.makeMove(Position.fromString("e2"), Position.fromString("e3"))
game.makeMove(Position.fromString("f1"), Position.fromString("e2"))
game.makeMove(Position.fromString("e1"), Position.fromString("g1"))

def printBoard(board: Board): String =
    for 
        row <- 1 to 8
        col <- 1 to 8
    yield
        ???
    "hi"

val mutMap = TrieMap(1 -> "a", 2 -> "b", 3 -> "c", 4 -> "d")
// mutMap.foreach( (i, s) => 
//     if i <= 3 then mutMap.update(i + 50, f"$i")
//     if i == 4 then mutMap.remove(1)
//     println(mutMap.toString() + f"i = $i")
//     )

boundary:
    mutMap.foreach((i,s) => if i == 4 then boundary.break(i) else println(i))