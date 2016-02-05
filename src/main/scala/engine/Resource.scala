package engine

case class Resource[T](res: T) {
  def get(): T = res
}
