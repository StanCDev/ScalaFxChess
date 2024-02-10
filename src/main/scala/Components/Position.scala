package Components
import Board.*
/**
  * Class to model a chess position. 
  *
  * @param x (Byte) : value between 1 and 8
  * @param y (Byte) : value between 1 and 8
  */
case class Position(x : Byte, y : Byte){
  require(1 <= x && x <= Board.size && 1 <= y && y <= Board.size)

  def add(deltaX : Byte, deltaY : Byte) : Position = Position((x + deltaX).toByte, (y + deltaY).toByte)
    
  override def toString(): String = 
    x match
        case 1 => "A" + y
        case 2 => "B" + y
        case 3 => "C" + y
        case 4 => "D" + y
        case 5 => "E" + y
        case 6 => "F" + y
        case 7 => "G" + y
        case 8 => "H" + y
}

object Position:
  def fromString(str : String): Position =
    require(str.length() == 2, "String length not equal to 2")
    val letter = str.charAt(0)
    val y = str.charAt(1).toString().toByte
    letter match
      case 'A' | 'a' => Position(1,y)
      case 'B' | 'b'=> Position(2,y)
      case 'C' | 'c'=> Position(3,y)
      case 'D' | 'd'=> Position(4,y)
      case 'E' | 'e'=> Position(5,y)
      case 'F' | 'f'=> Position(6,y)
      case 'G' | 'g'=> Position(7,y)
      case 'H' | 'h'=> Position(8,y)
      case _ => throw new IllegalArgumentException("Not a valid position")
