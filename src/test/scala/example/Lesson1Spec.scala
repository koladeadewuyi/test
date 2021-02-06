package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

class Lesson1Spec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks {

  private val scenarios = Table(
    ("s", "array", "out"),
    ("abccdb", Array(0, 1, 2, 3, 4, 5), 2),
    ("aabbcc", Array(1, 2, 1, 2, 1, 2), 3),
    ("aaaa", Array(3, 4, 5, 6), 12),
    ("ababa", Array(10, 5, 10, 5, 10), 0),
  )

  forAll(scenarios) { (s, array, out) =>
    "solution" should s"return $out when given $s and ${array.mkString(", ")}" in {
      Lesson1.solution(s, array) shouldBe out
    }
  }

}
