package engine.managers

import scala.scalajs.js.annotation.JSExport
import scala.reflect._
import scala.collection.mutable

import engine.Resource

@JSExport
object ResourceManager {

  private val resources = mutable.Map[Tuple2[ClassTag[_], String], Resource[_]]()

  @JSExport
  def get[T: ClassTag](id: String)(implicit tag: ClassTag[T]): Option[T] =
    resources.get((tag, id)).map(_.get.asInstanceOf[T])

  @JSExport
  def set[T: ClassTag](id: String, res: Resource[T])(implicit tag: ClassTag[T]): Unit =
    resources((tag, id)) = res

  // def getOrDefault
  // def setDefault
}
