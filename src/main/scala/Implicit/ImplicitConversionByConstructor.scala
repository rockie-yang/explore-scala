package Implicit

object ImplicitConversionByConstructor extends App {


  // # Implicit Constructor

  // If we define a simple class
  class AClass {}

  // create an object
  val a = new AClass

  // if we call an undefined function hello()
  // the compiler will not happy and report an error
  // a.hello()

  // while that is not aways true in scala
  // if we have an implicit class,
  // which accept AClass object as an constructor parameter
  implicit class ACompatible(a: AClass) {
    def hello() = println("hello world")
  }

  // now we can call hello, the compiler is happy
  a.hello()

  // the compiler try to see if object has a function hello defined
  // hello is not defined in this case
  // the compiler try to check implicit, here is complicit constructor
  // AClass => ACompatible,
  // so the code actually will be compiled like
  new ACompatible(a).hello()

}
