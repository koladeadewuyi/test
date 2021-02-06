package example

import scala.annotation.tailrec

object Lesson3 {

  val onlyLetters = "[a-z]+"
  val MinLength = 1
  val MaxLength = 100000

  def solution(a: String, b: String): Int = {
    Seq(a, b).foreach { x =>
      require(x.length >= MinLength && x.length <= MaxLength, s"$x should be between $MinLength and $MaxLength")
      require(x.matches(onlyLetters), s"$x should only contain characters $onlyLetters")
    }
    computeMinCharsForAnagram(a, b).length + computeMinCharsForAnagram(b, a).length
  }


  @tailrec
  private def computeMinCharsForAnagram(a: String, b: String, notInArr: Seq[Char] = Nil): Seq[Char] = {
    if (a.isEmpty) notInArr
    else {
      val head = a.head
      if (b.contains(head)) computeMinCharsForAnagram(a.tail, removeChar(head, b), notInArr)
      else computeMinCharsForAnagram(a.tail, removeChar(head, b), notInArr :+ head)
    }
  }

  private def removeChar(char: Char, str: String): String = str.replaceFirst(char.toString, "")

}
