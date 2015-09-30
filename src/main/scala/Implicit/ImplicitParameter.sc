class ImplicitParameter {
  def invoke(x: Int) = {
    println(x)
    x
  }
}

def invoke(x: Int)(implicit ip: ImplicitParameter) = ip.invoke(x)

// we can not invoke now,
// since the compiler does not know where to find parameter ip
// invoke(23)

// now we define a val which is ImplicitParameter
val ip = new ImplicitParameter

// but since it is not specified as implicit
// we still can not invoke now
// invoke(23)

// now we define a implicit val which is an object of class ImplicitParameter
// the name does not matter, it can be anything
implicit val iip = new ImplicitParameter

// now we can invoke,
// the parameter @ip will be passed in automatically using iip
invoke(23)
