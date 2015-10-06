package Collection

import org.scalatest.{Matchers, FlatSpec}

class TestCollect extends FlatSpec with Matchers with org.scalactic.Equality[Array[Int]] {
    val ar = Array(2, 4, 5)

  "using /: and foldRight" should "have the same result" in {
    // 1 is the initial value
    // it first apply on the first  element 2, (i, result) is (2, 1) => 1 * 2 = 2
    // it then  apply on the second element 4, (i, result) is (4, 2) => 4 * 2 = 8
    // it then  apply on the third  element 5, (i, result) is (5, 8) => 5 * 8 = 40
    // so the result a single value 40
    //
    // item is in the left and result is in the right
    // because this is foldRight, fold to the right
    // that is also /: the slash is lean to the right
    //
    // that is also why result is the first element and i is the second
    // because we first have the initial result, then lean to the right
    val toTheRight = (1 /: ar) {
      (result, i) =>
        //        println(result, i)
        i * result
    }
    val foldRight = ar.foldRight(1) { (i, result) => i * result }
    // in this case, we did a product so it's the same with ar.product()

    assert(toTheRight == foldRight)

  }

  override def areEqual(a: Array[Int], b: Any): Boolean = {
    b match {
      case array: Array[Int] => a.sameElements(array)
      case _ => false
    }
  }
}
