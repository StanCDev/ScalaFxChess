package Components

import Components.Piece.*
import math.max
import math.abs
/**
  * ChessGame is a game of chess with a given board.
  *
  * @param board : Board with pieces to operate on
  */
class ChessGame(val board : Board):

    enum CastlingState:
        case CanCastle
        case CantCastle
    
    import CastlingState.*

    private var whiteCanCastleL = CanCastle
    private var whiteCanCastleR = CanCastle
    private var blackCanCastleL = CanCastle
    private var blackCanCastleR = CanCastle

    def legalMove(start: Position, end: Position): Boolean =
        val startPiece = board.getOrElse(start, Piece.Empty)
        val endPiece = board.getOrElse(end, Piece.Empty)
        if startPiece.isWhite && endPiece.isWhite && !(endPiece == Piece.Empty) 
        || !startPiece.isWhite && !endPiece.isWhite && !(endPiece == Piece.Empty) then return false
        startPiece match
            case Empty => false
            case King(isWhite) => kingMove(start,end,isWhite)
            case Queen(isWhite) => queenMove(start,end,isWhite)
            case Rook(isWhite) => rookMove(start,end,isWhite)
            case Knight(isWhite) => knightMove(start,end,isWhite)
            case Bishop(isWhite) => bishopMove(start,end,isWhite)
            case Pawn(isWhite) => pawnMove(start,end,isWhite)
    end legalMove

    def makeMove(start: Position, end: Position): Boolean = 
        val canMove = legalMove(start,end)
        val isCastlingMove = isCastleMove(start, end)
        println(f"Move is legal ${canMove}")
        if canMove && !isCastlingMove then
            val pieceStart = board.getOrElse(start, Piece.Empty)
            val pieceEnd = board.get(end)
            board.remove(start)
            board.update(end,pieceStart)
            // board.foreach(e => println(e))
            true
        else if canMove && isCastlingMove then 
            ???
            true
        else false

    def pawnMove(start: Position, end: Position, isWhite : Boolean): Boolean =
        val endPiece = board.getOrElse(end, Piece.Empty)
        if isWhite then 
            val forward = (start.x == end.x) && (start.y + 1 == end.y) && endPiece == Piece.Empty
            val forward2 = (start.x == end.x) && (start.y + 2 == end.y) && endPiece == Piece.Empty
            val diag = 
                endPiece != Piece.Empty 
                && !endPiece.isWhite 
                && (start.x == end.x + 1 && start.y + 1 == end.y || start.x == end.x - 1 && start.y + 1 == end.y)
            //println("forward: " +forward+ " forward2: " + (forward2 && start.y == 2) + " diag: "+diag)
            
            forward || diag || (forward2 && start.y == 2)
        else
            val forward = (start.x == end.x) && (start.y - 1 == end.y) && endPiece == Piece.Empty
            val forward2 = (start.x == end.x) && (start.y - 2 == end.y) && endPiece == Piece.Empty
            val diag = 
                endPiece != Piece.Empty 
                && endPiece.isWhite 
                && (start.x == end.x + 1 && start.y - 1 == end.y || start.x == end.x - 1 && start.y - 1 == end.y)
            //println("forward: " +forward+ " forward2: " + (forward2 && start.y == 7)+ " diag: "+diag)
            forward || diag || (forward2 && start.y == 7)
    end pawnMove

    private def knightMove(start: Position, end: Position, isWhite : Boolean): Boolean = 
        val deltax = math.abs(start.x - end.x)
        val deltay = math.abs(start.y - end.y)
        (deltax == 1 && deltay == 2) || (deltax == 2 && deltay == 1)

    private def bishopMove(start: Position, end: Position, isWhite : Boolean): Boolean = 
        diagonalPositions(start,end)

    private def queenMove(start: Position, end: Position, isWhite : Boolean): Boolean =
        linePositions(start,end) || diagonalPositions(start,end)

    private def rookMove(start: Position, end: Position, isWhite : Boolean): Boolean =
        val rookCanMove = linePositions(start,end)
        if isWhite && rookCanMove then
            if start == Position.fromString("h1") then whiteCanCastleR = CantCastle
            else if start == Position.fromString("a1") then whiteCanCastleL = CantCastle
            true
        else if !isWhite && rookCanMove then
            if start == Position.fromString("h8") then whiteCanCastleR = CantCastle
            else if start == Position.fromString("a8") then whiteCanCastleL = CantCastle
            true
        else
            false

    private def linePositions(start: Position, end: Position): Boolean =
        val deltax = math.abs(start.x - end.x)
        val deltay = math.abs(start.y - end.y)
        val lineCol = deltax == 0 || deltay == 0
        if lineCol then
            val signX = if start.x > end.x then -1 else 1 
            val signY = if start.y > end.y then -1 else 1
            val positions = for
                xs <- if deltax == 0 then Seq(0) else 0 to deltax
                ys <- if deltay == 0 then Seq(0) else 0 to deltay
            yield
                Position((start.x + signX * xs).toByte, (start.y + signY * ys).toByte)
            positions.forall(pos => if pos == start || pos == end then true else board.getOrElse(pos, Piece.Empty) == Piece.Empty)
        else
            false
    /**
      * 
      *
      * @param start
      * @param end
      * @return
      */
    private def diagonalPositions(start: Position, end: Position): Boolean =
        val deltax = math.abs(end.x - start.x)
        val deltay = math.abs(end.y - start.y)
        val diag = deltax == deltay
        if diag then
            val signX = if start.x > end.x then -1 else 1 
            val signY = if start.y > end.y then -1 else 1 
            val positions = for
                i <- 0 to deltax // 1 until deltax
            yield
                Position((start.x + signX * i).toByte, (start.y + signY * i).toByte)

            positions.forall(pos => if pos == start || pos == end then true else board.getOrElse(pos, Piece.Empty) == Piece.Empty)

            
        else
            false

    private def kingMove(start: Position, end: Position, isWhite : Boolean): Boolean = 
        //TODO : castling
        val oneSquare = math.max( math.abs(start.x - end.x) , math.abs(start.y - end.y)) == 1 //&& !isInCheckAt(end, isWhite)

        if oneSquare then 
            (if isWhite then
                whiteCanCastleR = CantCastle 
                whiteCanCastleL = CantCastle 
            else 
                blackCanCastleR = CantCastle
                blackCanCastleL = CantCastle
                )
            return true
            //If youre moving one square away no need to check for any castling
        
        val castling = if isWhite then 
            if start != Position.fromString("e1") then false
            else
                //castle right
                if end == Position.fromString("g1") then 
                    println("Want to castle right")
                    //println(f"$whiteCanCastleR , ${board.get(Position.fromString("f1")) == Piece.Empty } ,  ${!isInCheckAt(Position(6,1), isWhite)}")
                    whiteCanCastleR == CanCastle 
                    && board.getOrElse(Position.fromString("f1"), Piece.Empty) == Piece.Empty 
                    && !isInCheckAt(Position(6,1), isWhite)
                    && board.getOrElse(Position.fromString("g1"), Piece.Empty) == Piece.Empty 
                    && !isInCheckAt(Position(7,1), isWhite)
                //castle left
                else if end == Position(3,1) then
                    println("Want to castle left")
                    whiteCanCastleL == CanCastle 
                    && board.getOrElse(Position(4,1), Piece.Empty) == Piece.Empty 
                    && !isInCheckAt(Position(4,1), isWhite)
                    && board.getOrElse(Position(3,1), Piece.Empty) == Piece.Empty 
                    && !isInCheckAt(Position(3,1), isWhite)
                else false
        else
            if start != Position(5,8) then false
            else
            {
            //castle right
            if end == Position(7,8) then 
                println("Want to castle right")
                whiteCanCastleR == CanCastle 
                && board.getOrElse(Position(6,8), Piece.Empty) == Piece.Empty 
                && !isInCheckAt(Position(6,8), isWhite)
                && board.getOrElse(Position(7,8), Piece.Empty) == Piece.Empty 
                && !isInCheckAt(Position(7,8), isWhite)
            //castle left
            else if end == Position(3,8) then
                println("Want to castle left")
                whiteCanCastleL == CanCastle 
                && board.getOrElse(Position(4,8), Piece.Empty) == Piece.Empty 
                && !isInCheckAt(Position(4,8), isWhite)
                && board.getOrElse(Position(3,8), Piece.Empty) == Piece.Empty 
                && !isInCheckAt(Position(3,8), isWhite)
            else false
            }
        if castling && isWhite then 
            whiteCanCastleL = CantCastle
            whiteCanCastleR = CantCastle
        else if castling && !isWhite then 
            blackCanCastleL = CantCastle
            blackCanCastleR = CantCastle

        oneSquare || castling


    def leftWhiteCastle(start : Position, end : Position) = 
        start == Position.fromString("e1") 
        && end == Position.fromString("c1")

    def rightWhiteCastle(start : Position, end : Position) = 
        start == Position.fromString("e1") 
        && end == Position.fromString("h1")

    def leftBlackCastle(start : Position, end : Position) = 
        start == Position.fromString("e8") 
        && end == Position.fromString("c8")

    def rightBlackCastle(start : Position, end : Position) = 
        start == Position.fromString("e8") 
        && end == Position.fromString("h8")

    
    def isCastleMove(start : Position, end : Position): Boolean = 
        leftWhiteCastle(start,end)
        || rightWhiteCastle(start,end)
        || leftBlackCastle(start,end)
        || rightBlackCastle(start,end)

    
    def isInCheckAt(position : Position, isWhite : Boolean): Boolean = 
        //For all pieces of opposite color, check that king(isWhite) not contained in their list
        val filtered = board.filter((pos, piece) => piece.isWhite ^ isWhite) 
        if filtered.isEmpty then false else filtered.exists((pos, piece)=>  allPossibleMoves(pos).contains(position))
        
    /**
      * 
      *
      * @param start
      * @return
      */
    def allPossibleMoves(start: Position): List[Position] = 
        (for
            x <- 1 to 8
            y <- 1 to 8
            if legalMove(start, Position(x.toByte,y.toByte))
        yield
            Position(x.toByte,y.toByte)).toList
end ChessGame