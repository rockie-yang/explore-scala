package Collection

import utils.Assert._

object Map extends App{
  val lines = Array("The world is a book.", "If you do not travel,", "you only read a page")

  // the map below will generate array of array
  // and then we flatten it
  val map = lines.map(line => line.split("\\W+"))
  val flatten = map.flatten

  // flatMap is the combination of map and flatten
  val words = lines.flatMap(line => line.split("\\W+"))
  words === flatten
}
