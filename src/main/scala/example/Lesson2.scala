package example

import scala.annotation.tailrec

object Lesson2 {

  def solution(blocks: Array[Int]): Int = {
    require(blocks.length >= 2 && blocks.length <= 200000)
    blocks.indices.map { startingIndex =>
      val (leftBlocks, rightBlocks) = blocks.splitAt(startingIndex)
      Math.max(computeLongestDistance(leftBlocks.reverse, startingIndex), computeLongestDistance(rightBlocks, startingIndex))
    }.max
  }


  @tailrec
  private def computeLongestDistance(blocks: Array[Int], startingPoint: Int, currentBlockIndex: Int = 0): Int = {
    if (blocks.isEmpty) currentBlockIndex - startingPoint
    else {
      val currentBlock = blocks.head
      require(currentBlock >= 1 && currentBlock <= 1000000000)
      val remainingBlocks = blocks.tail
      val nextCurrentBlockIndex = if (remainingBlocks.nonEmpty && currentBlock > remainingBlocks.head) currentBlockIndex else currentBlockIndex + 1
      computeLongestDistance(remainingBlocks, startingPoint, nextCurrentBlockIndex)
    }
  }

}
