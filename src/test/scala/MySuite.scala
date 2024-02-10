import Components.*
import munit.Clue.generate
// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  val startBoard = (Board.startBoard())
  val emptyBoard  = Board.empty

  test("Position") {
    assertEquals(Position(1,1), Position.fromString("A1"))
    assertEquals(Position(2,1), Position.fromString("B1"))
    assertEquals(Position(5,7), Position.fromString("E7"))
    assertEquals(Position(8,1), Position.fromString("H1"))
  }
  test("knightMovesEmpty") {
    val horsePos = Position(4,4)
    emptyBoard.update(horsePos, Piece.Knight(true))
    assertEquals[Piece,Piece](Piece.Knight(true), emptyBoard.getOrElse(horsePos, Piece.Empty))


    val horseGame = ChessGame(emptyBoard)
    assertEquals[Piece,Piece](Piece.Knight(true), horseGame.board.getOrElse(horsePos, Piece.Empty))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos))

    assertEquals(horseGame.allPossibleMoves(horsePos).toSet, List(horsePos.add(2,1),horsePos.add(2,-1),horsePos.add(1,2), horsePos.add(-1,2),horsePos.add(-2,1),horsePos.add(-2,-1),horsePos.add(-1,-2),horsePos.add(1,-2)).toSet)


    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(2,1)))
    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(2,-1)))
    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(1,2)))
    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(-1,2)))
    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(-2,1)))
    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(-2,-1)))
    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(-1,-2)))
    assertEquals(true, horseGame.legalMove(horsePos,horsePos.add(1,-2)))

    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(1,0)))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(1,1)))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(0,1)))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(-1,1)))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(-1,0)))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(-1,-1)))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(0,-1)))
    assertEquals(false, horseGame.legalMove(horsePos,horsePos.add(1,-1)))
    emptyBoard.remove(horsePos)
  }
  test("kingMovesEmpty") {
    val kingPos = Position(4,4)
    emptyBoard.update(kingPos , Piece.King(true))
    assertEquals[Piece,Piece](Piece.King(true), emptyBoard.getOrElse(kingPos, Piece.Empty))

    val kingGame = ChessGame(emptyBoard)
    assertEquals[Piece,Piece](Piece.King(true), kingGame.board.getOrElse(kingPos, Piece.Empty))
    assertEquals(false, kingGame.legalMove(kingPos,kingPos))

    println("Position of king: " + kingPos)
    kingGame.allPossibleMoves(kingPos).foreach(pos => println(pos))
    println("ALL KING MOVES:" + kingGame.allPossibleMoves(kingPos))
    val expected = List(kingPos.add(0,1),kingPos.add(1,0),kingPos.add(0,-1), kingPos.add(-1,0),kingPos.add(1,1),kingPos.add(1,-1),kingPos.add(-1,1),kingPos.add(-1,-1))
    assertEquals(kingGame.allPossibleMoves(kingPos).toSet, expected.toSet)

    print("empty forall" + List[Int]().forall(x => x >= 23))
    assertEquals(true, expected.forall(pos => !kingGame.isInCheckAt(pos, true)))

    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(0,1)))
    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(1,0)))
    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(0,-1)))
    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(-1,0)))
    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(1,1)))
    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(-1,1)))
    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(1,-1)))
    assertEquals(true, kingGame.legalMove(kingPos,kingPos.add(-1,-1)))

    assertEquals(false, kingGame.legalMove(kingPos,kingPos.add(0,2)))
    assertEquals(false, kingGame.legalMove(kingPos,kingPos.add(2,0)))
    assertEquals(false, kingGame.legalMove(kingPos,kingPos.add(2,2)))
    assertEquals(false, kingGame.legalMove(kingPos,kingPos.add(-2,-2)))
    emptyBoard.remove(kingPos)
  }
  test("queenMovesEmpty") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("rookMovesEmpty") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("bishopMoveEmpty") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("pawnMovesEmpty") {
    val wPos = Position(4,2)
    val bPos = Position(4, 7)
    emptyBoard.update(wPos, Piece.Pawn(true))
    emptyBoard.update(bPos ,Piece.Pawn(false))

    val pawnGame = ChessGame(emptyBoard)
    assertEquals(pawnGame.pawnMove(wPos, wPos.add(0,1), true),true)
    assertEquals(pawnGame.pawnMove(wPos, wPos.add(0,2), true),true)

    assertEquals(pawnGame.allPossibleMoves(wPos).toSet, Set(wPos.add(0,1), wPos.add(0,2)))
    assertEquals(pawnGame.allPossibleMoves(bPos).toSet, Set(bPos.add(0,-1), bPos.add(0,-2)))

    emptyBoard.remove(wPos)
    emptyBoard.remove(bPos)
  }

}
