package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class Lesson3Spec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks {

  private val scenarios = Table(
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
