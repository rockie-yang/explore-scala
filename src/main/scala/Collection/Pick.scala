package Collection
import utils.Assert._

object Pick extends App {

  val c = List(1, 2, 4, 5)
  // get all elements except the first n
  // get all elements except the first n
  c.drop(2) === "List(4, 5)"

  // get all elements except the last n
  c.dropRight(2) === "Array(1, 2)"

  // dropWhile drop all the element DOES satisfy the predict
  // until comes to an element does NOT  satisfy the predict
  c.dropWhile(_ < 3) === "Array(4, 5)"

  // filter    get the element does     satisfy the predict
  // filterNot get the element does NOT satisfy the predict
  c.filter(_ % 2 == 0) === "List(2, 4)"
  c.filterNot(_ % 2 == 0) === "List(1, 5)"

  // find get the FIRST element if exist
  // or None if not exist
  c.find(_ == 3).isEmpty === false
  c.find(_ % 2 == 0).get === 2

  // get all elements except the last n
  c.dropRight(2) === "List(1, 2)"

  // dropWhile drop all the element DOES satisfy the predict
  // until comes to an element does NOT  satisfy the predict
  c.dropWhile(_ < 3) === "List(4, 5)"
}

