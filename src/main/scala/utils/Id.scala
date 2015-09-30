package utils

object Id {
  def id(obj: AnyRef) =
    Integer.toHexString(System.identityHashCode(obj))
}
