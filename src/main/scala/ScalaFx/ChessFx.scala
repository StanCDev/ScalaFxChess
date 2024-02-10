package ScalaFx
import scalafx.application.JFXApp3
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text
import scalafx.scene.layout.Pane
import scalafx.geometry.Pos
import scalafx.scene.layout.GridPane
import Components.ChessGame
import Components.Board
import scalafx.scene.shape.SVGPath
import scalafx.scene.layout.BorderPane
import scalafx.scene.control.Label
import scalafx.scene.shape.FillRule
import scalafx.scene.input.MouseEvent
import scalafx.beans.property.DoubleProperty
import Components.Board.size
import Components.Piece
import scalafx.scene.shape.StrokeLineCap
import scalafx.scene.input.KeyCode.P
import Components.Position
import scalafx.collections.ObservableMap
import scalafx.beans.property.IntegerProperty
import scalafx.scene.control.Button


object ChessFx extends JFXApp3 {

    val startBoard = Board.startBoard()
    startBoard.remove(Position(4,2))
    startBoard.remove(Position(2,2))
    val game = ChessGame(startBoard)
    val observableBoard : ObservableMap[Position, Piece] = ObservableMap(game.board.toSeq*)
    

    val counter = IntegerProperty(0)
    val boardW = 8
    val boardH = 8

    val darkSage = "#334938"
    val lightGreen = "#d9ead3"
    val paleBlue = "#a0d0d0"
    val sandyBrown = "#d9ae84"
    val sandyBrownDark = "#f7e7c9"

    // var offsetX : Double = 0
    // var offsetY: Double = 0
    // var x: Double = 0
    // var y: Double = 0


    override def start(): Unit = {
        val gridPane = new GridPane(){
        }
        val panes =
            (for 
                i <- (0 until boardH * boardW)
            yield
                (i -> new Pane(){
                    // style = "-fx-border-color: red;"
                    
                    val isWhite = isWhiteCell(i) // Check if the cell should be white
                    style = s"-fx-background-color: ${if (isWhite) sandyBrown else sandyBrownDark};"
                    prefWidth = 100
                    prefHeight = 100
                    alignmentInParent = Pos.Center
                    
                })).toMap
        
        for
            i <- (0 until boardW)
            j <- (0 until boardH)
        do
            gridPane.add(panes(j + boardH*i),j,i)
        
        
        val svgPieces = initBoard(gridPane.width.value,gridPane.height.value)


        // svgX.setOnMouseDragged( d =>
        //     svgX.layoutX.set(d.getX())
        //     svgX.layoutY.set(d.getY()))
        
        

        //given a click detect what pane it is in
        panes.foreach( (i, pane) => {}
            // pane.setOnMouseClicked(
            //     e =>
            //     println(f"clicked on pane $i")
            // )
        )

        val messagePane = new Pane {
                val label = new Label("Your message here")
                // label.text <== message
                // label.font = Font.font("Arial", 20)
                children = label
            }

        // val b = Button("+ 1")
        // b.setOnMouseClicked(e => 
        //     println(counter.value)
        //     val i = counter.value
        //     panes(i).style.set("-fx-background-color: black;")
        //     counter.set(counter.value + 1)
        //     )

        // val buttonPane = new Pane {
        //     children = b
        // }
        
        val mixedPane = new BorderPane(){
                //top = buttonPane
                center = gridPane
                bottom = messagePane
                style = f"-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: ${paleBlue};"
                // left = new Pane()
                // override def height: ReadOnlyDoubleProperty = DoubleProperty( resetButtonPane.height.toDouble + gridPane.height.toDouble + messagePane.height.toDouble )
            }

        val pcs = svgPieces.map( (k,v) => k).toSeq
        observableBoard.addListener(e => 
            if e.wasRemoved() then ???
            else if e.wasAdded() then ???
            ???)

        svgPieces.foreach( (svg, pos) => 
            var (offsetX, offsetY) = pos._1
            var (x,y) = pos._2
            val start = squareFromPos(svg.layoutX.value, svg.layoutY.value, 800,800)// TODO: gridPane.width.value, gridPane.height.value)
            val originalColor = svg.fill.getValue()

            svg.setOnMousePressed(e => 
                // Capture the initial mouse cursor position
                    //svg.fill = Paint.valueOf("red")
                    svg.setOpacity(0.5)
                    offsetX = e.getSceneX() - svg.getLayoutX()
                    offsetY = e.getSceneY() - svg.getLayoutY()
                    svgPieces.addOne(svg, ((offsetX, offsetY), (x,y)))
                    //panes(23).style.set("-fx-background-color: beige, rgba(255, 0, 0, 0.3);")
                    //game.allPossibleMoves(start).foreach(p => println(p))
                    val dests = game.allPossibleMoves(start).map(pos => pos.x + (8-pos.y)*8 -1 )
                    //(1 to 8).foreach(y => (1 to 8).foreach(x => println(f"Pos($x,$y) = ${Position(x.toByte,y.toByte)} mapped to ${x +(8-y)*8 -1 }")))
                    dests.foreach(i => panes(i).style.set("-fx-background-color: beige, rgba(255, 0, 0, 0.3);"))
            )


            svg.setOnMouseDragged(e => {
                    // Update the text position based on mouse cursor movement
                    val (newX, newY) = clamp(e.getSceneX() - offsetX, e.getSceneY() - offsetY, gridPane.width.value, gridPane.height.value)
                    svg.layoutX.set(newX)
                    svg.layoutY.set(newY)
                    x = newX
                    y = newY
                    svgPieces.addOne(svg, ((offsetX, offsetY), (x,y)))
                });

            svg.setOnMouseReleased(e => 
                    panes.foreach( (i, pane) => pane.style.set(f"-fx-background-color: ${if isWhiteCell(i) then sandyBrown else sandyBrownDark};"))
                    val end = squareFromPos(x, y, gridPane.width.value, gridPane.height.value)
                    println("End position: " + end)
                    val moveIsLegal = game.makeMove(start,end) // game.legalMove(start,end)
                    val p = if moveIsLegal then 
                        clampToSquare(end, gridPane.width.value, gridPane.height.value, 0, 0)
                        else
                            clampToSquare(start, gridPane.width.value, gridPane.height.value, 0, 0)
                    //TESTING HERE
                    println(f"Start piece: ${game.board.getOrElse(start, Piece.Empty)} , Start pos: $start")
                    println(f"End piece: ${game.board.getOrElse(end, Piece.Empty)} , end pos: $end")
                    //
                    svg.layoutX.set(p._1)
                    svg.layoutY.set(p._2)
                    svg.setOpacity(1)
                    //svg.fill = ???
                    svgPieces.addOne(svg, ((offsetX, offsetY), (x,y)))
            )
            )

        
        stage = new JFXApp3.PrimaryStage {
        // override def width = mixedPane.width
        // override def height = mixedPane.height



        title = "ChessFx"
        scene = new Scene(/*sceneWidth, sceneHeight*/){
            content = Seq(mixedPane) ++ pcs
            //gridPane.children = dragLabel
        }
            //gridPane.children = dragLabel
        }

    }


    private def isWhiteCell(i : Int): Boolean = if (i / 8 ) % 2 == 0 then (i+1) % 2 == 0 else i % 2 == 0 

    private def squareFromPos(x: Double, y : Double, w : Double, h : Double): Position = 
        println(f"x: $x , y: $y , w: $w , h: $h" )
        val tileX = (math.floor( ( x / w ) *  8 + {if x != w then 1 else 0})).toByte
        val tileY = (9 - math.floor((y / h) * 8 +  {if y != h then 1 else 0})).toByte
        println(f"tileX, $tileX , tileY: $tileY")
        Position(tileX , tileY)

    private def clampToSquare(square : Position, w : Double, h : Double, itemW: Double = 0, itemH: Double = 0) = 
        val newX = square.x
        val newY = 9 - square.y // 9 - y
        val px =  (newX) * (w / 8) - w / 16 - itemW/2
        val py = (newY ) * (h / 8) -  h/ 16 - itemH/2
        (px, py)

    private def clamp(newX : Double, newY : Double, w : Double, h : Double) = 
        (math.min( math.max(0, newX), w) , math.min( math.max(0, newY), h))

    private def initBoard(w : Double, h : Double): ObservableMap[SVGPath, ((Double, Double), (Double, Double))] = 
        ObservableMap(game.board.map((pos, piece) => ( makeSVG(piece, pos, 800, 800),  ( (0d,0d), (0d,0d)  )  )).toSeq*)

    
    private def makeSVG(piece: Piece, pos: Position, w : Double, h: Double): SVGPath = 
        new SVGPath {
                println(f"Piece : $piece , Position: $pos")
                content = PieceSVG.toSVG(piece) //Might have to change this
                fill = if piece.isWhite then Color.White else Color.Black
                stroke = Color.Black
                strokeWidth = 1// Adjust the thickness as needed
                scaleX = 2
                scaleY = 2
                pickOnBounds = true
                val p = clampToSquare(pos,w,h,0,0)
                layoutX = p._1
                layoutY = p._2
            }
}