package Collection
import utils.Assert._

object Concatenation extends App {

  // # Concatenation

  // ## Array Concatenation
  val a = Array(1, 2)
  val b = Array(4, 5)
  val c = a ++ b

  // you might expect equals will compare the real content
  // but it actually compare identity for Array
  // the same as you do "3" == "3" in Java, which will get false
  val arrayEqualsWillSurpriseU = c.equals(Array(1, 2, 4, 5))

  // if we wanna compare the content, using sameElements
  c.sameElements(Array(1, 2, 4, 5))

  c.mkString(",") == "1,2,4,5"

  // prepend an element in the front
  // notice: + is in the front, and : is in the back
  // +: is right associative, which means +: is an function of Array
  (3 +: a).mkString(",") == "3,1,2"

  // append an element in the end
  // the + is in the back, that's why it's append in the end
  (a :+ 3).mkString(",") == "1,2,3"
}