package Components

import scala.runtime.stdLibPatches.language.experimental.namedTypeArguments

sealed trait Piece {
  def isWhite: Boolean
}

object Piece {
  case class King(isWhite: Boolean) extends Piece
  case class Queen(isWhite: Boolean) extends Piece
  case class Rook(isWhite: Boolean) extends Piece
  case class Knight(isWhite: Boolean) extends Piece
  case class Bishop(isWhite: Boolean) extends Piece
  case class Pawn(isWhite: Boolean) extends Piece
  
  case object Empty extends Piece {
    val isWhite: Boolean = false // You can set this to true or false based on your requirements
  } 
}