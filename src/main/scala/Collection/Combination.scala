package Collection
import utils.Assert._

object Combination extends App {

  // get the combination from a collection
  // the result is an iterator
  val comb1 = List(1, 2).combinations(1)
  comb1.getClass.getName

  // Set with Array elements can not be simply compare the equality
  // because array can not be simply compare the equality :-(

  // get all identical combinations with one element
  // get 1 element from (1,2) should got (1) (2)
  List(1, 2).combinations(1).toSet === Set(List(1), List(2))

  // get 3 elements from (1,2,4,5) should got
  // (1,2,4) (1,2,5) (1,4,5) (2,4,5)
  List(1, 2, 4, 5).combinations(3).toSet === Set(List(1, 2, 4), List(1, 2, 5), List(1, 4, 5), List(2, 4, 5))
}