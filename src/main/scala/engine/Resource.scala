package engine
import scala.scalajs.js.annotation.JSExport

@JSExport
case class Resource[T](res: T) {

  @JSExport
  def get(): T = res

}
