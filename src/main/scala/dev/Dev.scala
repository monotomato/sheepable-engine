package dev

import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.JSApp
import org.scalajs.dom

import engine._

object DevApp extends JSApp {

  def main(): Unit = {
    init()
  }

  def init(): Unit = {
    var res = Resource("Morjes")
    var res2 = Resource("Moro")

    println("Hello from scalajs!")
    println(res)
    println(res2)
  }
}
