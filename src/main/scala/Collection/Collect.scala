package Collection
import utils.Assert._

object Collect extends App {
  val c = Array(1, 2, 4, 5)
  // collect can be used the same as filter if the value is not mapped
  // a bit verbose then filter through
  val asFilter = c.collect { case i if i % 2 == 0 => i }
  val filter = c.filter(_ % 2 == 0)
  asFilter === filter

  // collect should be mostly used as a combination of filter and map
  val even1 = c.collect { case i if i % 2 == 0 => f"$i is even" }
  val even2 = c.filter(_ % 2 == 0).map { i => f"$i is even" }
  even1 === even2 === "Array(2 is even, 4 is even)"

  // collectFirst can be used the same as find if the value is not mapped
  val asFind = c.collectFirst { case i if i % 2 == 0 => i }
  val find = c.find(_ % 2 == 0)
  asFind.get === find.get

  // collectFirst should be mostly used as a combination of find and map
  val firstEven = c.collectFirst { case i if i % 2 == 0 => f"$i is the first even" }
  firstEven.get === "2 is the first even"

  // None will be returned if the value does not exist
  c.collectFirst { case i if i > 10 => i } === None
}