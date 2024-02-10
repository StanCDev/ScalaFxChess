package PGN
import Components.Move

object PgnParser:
    
    val moveNumber = """\d+\.""".r

    def parse(pgn: String): Seq[Move] = ???


// def managerRepl(): Unit =
//   val ADD_RE = """add\s+(\d+)\s+(.*)""".r
//   val ADD_AFTER_RE = """addafter\s+(\d+)\s+(\d+)\s+(.*)""".r
//   val tasks = collection.mutable.ArrayBuffer.empty[Future[String]]

//   @annotation.tailrec
//   def loop(): Unit =
//     val source = scala.io.StdIn.readLine(text = "> ")
//     source.trim() match
//       case "quit" | "exit" =>
//         Await.result(Future.sequence(tasks), 2.seconds)
//         ()
//       case ADD_RE(duration, result) =>
//         val taskId = tasks.size
//         val future = Future:
//           println(s"Started task: #$taskId")
//           Thread.sleep(duration.toLong * 1000)
//           println(s"Finished task: #$taskId , $result")
//           result
//         tasks += future
//         loop()
//       case ADD_AFTER_RE(after, duration, result) =>
//         // if tasks.contain(after) wait until after is done
//         //else just go normally
//         if after.toInt < 0 || after.toInt >= tasks.length then
//           print("Invalid task number: $after")
//           loop()
//         else
//           val taskId = tasks.size
//           val toBeFinished = tasks(after.toInt)
//           val future = toBeFinished.flatMap:
//             s =>
//               Future:
//                 println(s"Started task: #$taskId")
//                 Thread.sleep(duration.toLong * 1000)
//                 println(s"Finished task: #$taskId , $result")
//                 result
//           tasks += future
//           loop()
//       case s =>
//         if s.nonEmpty then
//           println(s"Unrecognized command: $source")
//         loop()

//   loop()
