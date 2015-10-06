package ScalaCheck

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.prop.Checkers


object StringSpecification extends Properties("String") {

  property("startsWith") = forAll { (a: String, b: String) =>
    (a+b).startsWith(a)
  }

  property("concatenate") = forAll { (a: String, b: String) =>
    (a+b).length > a.length && (a+b).length > b.length
  }

  property("substring") = forAll { (a: String, b: String, c: String) =>
    (a+b+c).substring(a.length, a.length+b.length) == b
  }

}


class StringSpecification extends FlatSpec with Checkers with Matchers{
 "A String concatenation" should "start with first string" in {
   check { (a: String, b: String) =>
       (a+b).startsWith(a)
   }
   check(StringSpecification)
 }

}