package Collection
import utils.Assert._

object Predict extends App {

  val c = List(1, 2, 4, 5)
  // test if an element is existed in the array
  c.contains(1) === true

  // test a slice is existed in the array
  // the slice does not have to be the same collection
  // it only need be SeqLike
  c.containsSlice(List(2, 4)) === true

  // check if the array ends with a Seq
  c.endsWith(List(4, 5)) === true
  c.endsWith(List(4, 6)) === false

  // check if exist any element that satisfy the predict
  // it is similar with contains, just contain only can test _ == el
  // whether exists any element in collection @c which % 2 == 0
  c.exists(_ % 2 == 0) === true

  // check if all elements satisfy the predict
  // whether all element in collection @c > 0
  c.forall(_ > 0) === true
}