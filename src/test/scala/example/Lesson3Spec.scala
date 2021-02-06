package example

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class Lesson3Spec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val scenarios = Table(
    ("word1", "word2", "out"),
    ("rather", "harder", 2),
    ("apple", "pear", 3),
    ("lemon", "melon", 0)
  )

  forAll(scenarios) { (word1, word2, out) =>
    "solution" should s"return $out when given $word1, and $word2" in {
      Lesson3.solution(word1, word2) shouldBe out
    }
  }

}
