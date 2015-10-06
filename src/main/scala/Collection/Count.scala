package Collection
import utils.Assert._

object Count extends App {

  val c = List(1, 2, 3, 4)
  // get how many elements satisfy a predict
  c.count(_ % 2 == 0) === 2

  // through we can use filter and length to get the count as well
  // while that takes more space
  c.filter(_ % 2 == 0).length === 2
}