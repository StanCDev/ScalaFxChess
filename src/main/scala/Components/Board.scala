package Components


import scala.collection.mutable.Map

type Board = Map[Position, Piece]

object Board:
    val size = 8
    def empty : Board = Map[Position, Piece]()
    def startBoard(): Board = 
        val piecesMap: Map[Position, Piece] = Map(
          Position(1, 1) -> Piece.Rook(isWhite = true),
          Position(2, 1) -> Piece.Knight(isWhite = true),
          Position(3, 1) -> Piece.Bishop(isWhite = true),
          Position(4, 1) -> Piece.Queen(isWhite = true),
          Position(5, 1) -> Piece.King(isWhite = true),
          Position(6, 1) -> Piece.Bishop(isWhite = true),
          Position(7, 1) -> Piece.Knight(isWhite = true),
          Position(8, 1) -> Piece.Rook(isWhite = true),
          Position(1, 2) -> Piece.Pawn(isWhite = true),
          Position(2, 2) -> Piece.Pawn(isWhite = true),
          Position(3, 2) -> Piece.Pawn(isWhite = true),
          Position(4, 2) -> Piece.Pawn(isWhite = true),
          Position(5, 2) -> Piece.Pawn(isWhite = true),
          Position(6, 2) -> Piece.Pawn(isWhite = true),
          Position(7, 2) -> Piece.Pawn(isWhite = true),
          Position(8, 2) -> Piece.Pawn(isWhite = true),
          Position(1, 7) -> Piece.Pawn(isWhite = false),
          Position(2, 7) -> Piece.Pawn(isWhite = false),
          Position(3, 7) -> Piece.Pawn(isWhite = false),
          Position(4, 7) -> Piece.Pawn(isWhite = false),
          Position(5, 7) -> Piece.Pawn(isWhite = false),
          Position(6, 7) -> Piece.Pawn(isWhite = false),
          Position(7, 7) -> Piece.Pawn(isWhite = false),
          Position(8, 7) -> Piece.Pawn(isWhite = false),
          Position(1, 8) -> Piece.Rook(isWhite = false),
          Position(2, 8) -> Piece.Knight(isWhite = false),
          Position(3, 8) -> Piece.Bishop(isWhite = false),
          Position(4, 8) -> Piece.Queen(isWhite = false),
          Position(5, 8) -> Piece.King(isWhite = false),
          Position(6, 8) -> Piece.Bishop(isWhite = false),
          Position(7, 8) -> Piece.Knight(isWhite = false),
          Position(8, 8) -> Piece.Rook(isWhite = false)
        )
        //b.add(piecesMap)
        //return b
        piecesMap
    end startBoard