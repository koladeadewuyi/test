package example

//import scala.annotation.tailrec
import scala.collection.parallel.CollectionConverters._

object Lesson5 {

  private val MinLength = 0
  private val MaxLength = 200
  private val LowerCasedEnglishLetters = s"^[a-z]{$MinLength,$MaxLength}" + "$"

  def solution(inputStrings: Array[String]): Either[String, String] = {
//    require(inputStrings.length >= MinLength && inputStrings.length <= MaxLength, s"Input string array must be between $MinLength and $MaxLength long")
//    inputStrings.headOption.map { firstString =>
//      validate(firstString)
//      inputStrings.tail.par.map { currentString =>
//        validate(currentString)
//        longestCommonPrefix(firstString, currentString)
//      }
//    }.getOrElse(Array("").par).minBy(_.length)

    inputStrings match {
      case Array(firstString, _*) if inputStrings.length >= MinLength && inputStrings.length <= MaxLength =>
        validate(firstString)
          .flatMap { validFirstStr =>
          inputStrings.tail.par
            .map(validate(_).map(longestCommonPrefix(validFirstStr, _)))
            .minBy(_.getOrElse("").length)
        }
      case Array(_, _*) => Left(s"requirement failed: Input string array must be between $MinLength and $MaxLength long")
      case _ => Right("")
    }
  }


//  @tailrec
//  private def longestCommonPrefix(firstString: String, currentString: String, commonPrefix: String = ""): String = {
//    if (firstString.isEmpty || currentString.isEmpty) commonPrefix
//    else {
//      val firstStringHead = firstString.head
//      if (firstStringHead == currentString.head) longestCommonPrefix(firstString.tail, currentString.tail, commonPrefix + firstStringHead)
//      else longestCommonPrefix(firstString = "", currentString = "", commonPrefix)
//    }
//  }

//  private def validate(input: String): Unit = require(
//    input.matches(LowerCasedEnglishLetters),
//    s"[$input] must only contain lower case english letters $MinLength to $MaxLength long"
//  )

  private def validate(input: String): Either[String, String] = {
    if (input.matches(LowerCasedEnglishLetters)) Right(input)
    else Left(s"requirement failed: [$input] must only contain lower case english letters $MinLength to $MaxLength long")
  }

  private def longestCommonPrefix(firstString: String, currentString: String): String = {
    firstString.view.zip(currentString).takeWhile(Function.tupled(_ == _)).map(_._1).mkString
  }

}
