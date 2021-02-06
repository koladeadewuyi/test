package example

import scala.annotation.tailrec

object Lesson4 {

  private val MinXIntValue = 0
  private val MinYIntValue = 1
  private val MaxIntValue = 2000000000
  private val MinNValue = 1
  private val MaxNValue = 100000

  def solution(x: Array[Int], y: Array[Int]): Int = {
    require(x.length == y.length, s"x: [${x.mkString(",")}] should be same length as y: [${y.mkString(",")}]")
    maxEqualFractions(x, y)
  }


  @tailrec
  private def maxEqualFractions(x: Array[Int], y: Array[Int], fractions: Map[String, Int] = Map.empty): Int = {
    if (x.isEmpty || y.isEmpty) fractions.valuesIterator.max
    else {
      val xHead = x.head
      val yHead = y.head
      require(xHead >= MinXIntValue && xHead <= MaxIntValue, s"$xHead should be within $MinXIntValue and $MaxIntValue")
      require(yHead >= MinYIntValue && yHead <= MaxIntValue, s"$yHead should be within $MinYIntValue and $MaxIntValue")
      val fractionCount = fractions.getOrElse(s"${xHead.toFloat / yHead.toFloat}", 0)
      val newFractionCount = fractionCount + 1
      require(newFractionCount >= MinNValue && newFractionCount <= MaxNValue)
      maxEqualFractions(x.tail, y.tail, fractions + (s"${xHead.toFloat / yHead.toFloat}" -> newFractionCount))
    }
  }

}
