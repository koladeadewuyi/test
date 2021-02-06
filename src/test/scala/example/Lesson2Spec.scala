package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class Lesson2Spec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks {

  private val scenarios = Table(
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
