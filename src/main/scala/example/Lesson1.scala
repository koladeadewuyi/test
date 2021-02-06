package example

import scala.annotation.tailrec

object Lesson1 {

  def solution(s: String, c: Array[Int]): Int = {
    require(s.length == c.length)
    calculateCost(s, c)
  }

  @tailrec
  private def calculateCost(s: String, c: Array[Int], cost: Int = 0): Int = {
    if (s.length < 2) cost
    else {
      val arrayTail = c.tail
      val stringTail = s.tail
      val (cost1, cost2) = if (s.head == stringTail.headOption.getOrElse(0)) {
        (cost + c.head, cost + arrayTail.headOption.getOrElse(0))
      } else (cost, cost)
      val lowestCost = if (cost1 > cost2) cost2 else cost1
      calculateCost(stringTail, arrayTail, lowestCost)
    }
  }

}
