package Reflect

import scala.reflect.runtime.universe._
object TryReflect {

  def main(args: Array[String]): Unit = {
    val typeOfOption = typeOf[Option[_]]
    val get = typeOfOption.member(TermName("get")).asMethod
    println(get.paramLists)
    println(get.toString)
  }
}
