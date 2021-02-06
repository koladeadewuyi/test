package example

object Exits {

  def main(args: Array[String]): Unit = {
    try {
      try {
        sys.exit(1)
      } finally {
        println("Finally block 1")
      }
    } finally {
      println("Finally block 2")
    }
  }
}

