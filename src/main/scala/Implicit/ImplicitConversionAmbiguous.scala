// # Ambiguous implicit conversion
package Implicit

object ImplicitConversionAmbiguous extends App {


  class AClass

  val a = new AClass

  // if we have an implicit class,
  // which accept AClass object as an constructor parameter
  implicit class ACompatible(a: AClass) {
    def hello() = println("hello world")
  }

  implicit def aToCompatible(a: AClass): ACompatible = new ACompatible(a)

  // compiler will complain when there are ambiguous
  // since the compiler does not know which one to choose

  // a.hello() can be compiled one of following
  aToCompatible(a).hello()
  new ACompatible(a).hello()
}