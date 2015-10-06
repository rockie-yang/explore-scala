package Collection
import utils.Assert._

object Copy extends App {

  val c = Array(1, 2, 4, 5)

  // copy from a bigger array to a small array
  // will NOT get exception
  // the smaller part will be copied
  val arSmaller = new Array[Int](3)
  c.copyToArray(arSmaller)
  arSmaller === "Array(1, 2, 4)"

  // copy from a smaller array to a bigger array
  // will keep extra elements unchanged
  val arBigger = new Array[Int](5)
  arBigger === "Array(0, 0, 0, 0, 0)"
  c.copyToArray(arBigger)
  arBigger.deep.toString() === "Array(1, 2, 4, 5, 0)"

  // Array.copyToArray(xs: Array, start: Int)
  // copy source array to the dest array at start point
  // the start is the place at dest array
  val arStart = new Array[Int](3)
  c.copyToArray(arStart, 2)
  arStart.deep.toString() === "Array(0, 0, 1)"

  // limit the number of element to be copied
  // exceed the length of dest array will be ignored
  c.copyToArray(arStart, 1, 3)
  arStart.deep.toString() === "Array(0, 1, 2)"

  // distinct build a new array
  // it is decoupled between the source array and dest array
  // change one array will not affect the other
  val d = c.distinct
  d(1) = 3
  c === "Array(1, 2, 4, 5)"
  d === "Array(1, 3, 4, 5)"
}