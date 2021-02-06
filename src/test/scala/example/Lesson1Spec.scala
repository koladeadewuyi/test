package example

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class Lesson1Spec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val scenarios = Table(
    ("s", "array", "out"),
    ("abccdb", Array(0, 1, 2, 3, 4, 5), 2),
    ("aabbcc", Array(1, 2, 1, 2, 1, 2), 3),
    ("aaaa", Array(3, 4, 5, 6), 12),
    ("ababa", Array(10, 5, 10, 5, 10), 0),
  )

  forAll(scenarios) { (s, array, out) =>
    "solution" should s"return $out when given $s and $array" in {
      Lesson1.solution(s, array) shouldBe out
    }
  }

}
