package example

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.EitherValues

class Lesson5Spec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks with EitherValues {

  private val MinLength = 0
  private val MaxLength = 200

  private val scenarios = Table(
    ("inputStrings", "longestCommonPrefix"),
    (Array("boat", "car", "airplane"), ""),
    (Array("flower", "flow", "flight"), "fl"),
    (Array("", "flow", "flight"), ""),
    (Array.empty[String], ""),
    (Array("dog","racecar","car"), "")
  )

  forAll(scenarios) { (inputStrings, longestCommonPrefix) =>
    "solution" should s"return [$longestCommonPrefix] as the longest common prefix when given strings ${inputStrings.mkString(", ")}" in {
      Lesson5.solution(inputStrings).value shouldBe longestCommonPrefix
    }
  }

  private val errorScenarios = Table(
    ("inputStrings", "errorMsg"),
    (Array("1boat", "car", "airplane"), s"requirement failed: [1boat] must only contain lower case english letters $MinLength to $MaxLength long"),
    (Array("Boat", "car", "airplane"), s"requirement failed: [Boat] must only contain lower case english letters $MinLength to $MaxLength long"),
    (Array("A dog","racecar","car"), s"requirement failed: [A dog] must only contain lower case english letters $MinLength to $MaxLength long"),
    ((1 to MaxLength + 1).flatMap(_ => Array("abc")).toArray, s"requirement failed: Input string array must be between $MinLength and $MaxLength long"),
    ((1 to MaxLength + 1).map(_.toString).toArray, s"requirement failed: Input string array must be between $MinLength and $MaxLength long")
  )

  forAll(errorScenarios) { (inputStrings, errorMsg) =>
    "solution" should s"return validation error when given strings ${inputStrings.mkString(", ")}" in {
      Lesson5.solution(inputStrings).left.value shouldBe errorMsg
    }
  }

}
