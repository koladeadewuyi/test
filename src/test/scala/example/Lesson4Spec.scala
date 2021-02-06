package example

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class Lesson4Spec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val scenarios = Table(
    ("x", "y", "out"),
    (Array(1, 2, 3, 4, 0), Array(2, 3, 6, 8, 4), 3),
    (Array(3, 3, 4), Array(5, 4, 3), 1),
    (Array(4, 4, 7, 1, 2), Array(4, 4, 8, 1, 2), 4),
    (Array(1, 2, 3, 1, 2), Array(2, 4, 6, 5, 10), 3)
  )

  forAll(scenarios) { (x, y, out) =>
    "solution" should s"return $out when given ${x.mkString(",")}, and ${y.mkString(",")}" in {
      Lesson4.solution(x, y) shouldBe out
    }
  }

}
