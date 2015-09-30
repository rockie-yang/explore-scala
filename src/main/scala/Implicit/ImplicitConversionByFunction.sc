// # Implicit Function Conversion

// If we define a simple class
class AClass

// create an object
val a = new AClass

// if we call an undefined function hello()
// the compiler will not happy and report an error
//a.hello()

// object of AClass will not be automatically converted to ACompatible
// if the constructor is not implicit
class ACompatible(a: AClass) {
  def hello() = println("hello world")
}

// we still can not invoke a.hello()
//a.hello()

// here we define an implicit function from AClass => ACompatible
// the function name can be anything,
implicit def aToCompatible(a: AClass): ACompatible = new ACompatible(a)

// how we can invoke a.hello()
a.hello()

// the compiler try to see if AClass has a function hello defined
// hello is not defined in this case
// the compiler try to check implicit, here is implicit function
// AClass => ACompatible,
// so the code actually will be compiled like
// aToCompatible(a).hello()



