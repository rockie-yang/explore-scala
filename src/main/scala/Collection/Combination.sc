import utils.Assert._

val a = Array(1, 2)

// get all identical combinations with one element
// get 1 element from (1,2) should got (1) (2)
val comb1 = a.combinations(1).toSet

// Set with Array elements can not be simply compare the equality
// because array can not be simply compare the equality :-(
assert(comb1 != Set(Array(1), Array(2)))

// while other collection rather than array can compare the equality
assert(a.toList.combinations(1).toSet == Set(List(1), List(2)))

// get 3 elements from (1,2,4,5) should got
// (1,2,4) (1,2,5) (1,4,5) (2,4,5)
val comb3 = Array(1,2,4,5).combinations(3).toSet
comb3 === Set(List(1,2,4), List(1,2,5), List(1,4,5), List(2,4,5))