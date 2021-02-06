package example

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class Lesson2Spec extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val scenarios = Table(
    ("blocks", "out"),
    (Array(2, 6, 8, 5), 3),
    (Array(1, 5, 5, 2, 6), 4),
    (Array(1, 1), 2)
  )

  forAll(scenarios) { (blocks, out) =>
    "solution" should s"return $out when given [${blocks.mkString(",")}]" in {
      Lesson2.solution(blocks) shouldBe out
    }
  }

}
