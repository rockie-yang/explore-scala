import utils.Id.id
import utils.Assert.toAssert

val a = Array(1, 2)
val b = Array(4, 5)
val c = a ++ b
val sb1 = new StringBuilder   // sb1 is "" now

// content in c added to sb1 without separator
val sb2 = c.addString(sb1)

// sb1 sb2 are the same object, it's identical
// not only the content is the same
id(sb1) === id(sb2)

// sb1 and sb2 are identical
// the value is 1245
sb1.toString() === sb2.toString === "1245"

// Array.addString(sb: StringBuilder, sep: String)
//   ===> is the same with
// Array.mkString(sep: String)
//   if
// the sb is empty at the time
c.addString(new StringBuilder, ",").toString === "1,2,4,5"

// other wise the content is concatenated to the String Builder
// sb1 is 1245 now
c.addString(sb1, ",").toString() === "1245" + c.mkString(",")

// Array.addString(sb: StringBuilder, start: String, sep: String, end: String)
// ===> is the same with
// Array.mkString(start: String, sep: String, end: String)
val sb4 = c.addString(new StringBuilder(), "start: (", ",", ")")
sb4.toString() === "start: (1,2,4,5)"
sb4.toString() === c.mkString("start: (", ",", ")")

// mkString should be used in most case, one time convert to string
// addString should be used if want to continually add up

// using deep.toString to get more readable output
// this can be only used to array and multiple level of array
c.deep.toString() === "Array(1, 2, 4, 5)"