package example

import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Lesson6LRUCacheTest extends AnyFlatSpec with Matchers with OptionValues {

  val FirstTestKey = "firstTestKey"
  val FirstTestValue = "firstTestValue"

  val SecondTestKey = "secondTestKey"
  val SecondTestValue = "secondTestValue"

  val ThirdTestKey = "thirdTestKey"
  val ThirdTestValue = "thirdTestValue"

  it should "add single item to cache when within capacity" in {
    val cache = new Lesson6LRUCache(capacity = 1)

    cache.set(key = FirstTestKey, value = FirstTestValue)

    cache.get(key = FirstTestKey).value shouldBe FirstTestValue
    cache.length() shouldBe 1
  }

  it should "update item when entry key already exists" in {
    val cache = new Lesson6LRUCache(capacity = 2)

    cache.set(key = FirstTestKey, value = FirstTestValue)
    cache.get(key = FirstTestKey).value shouldBe FirstTestValue
    cache.length() shouldBe 1

    cache.set(key = FirstTestKey, value = SecondTestValue)
    cache.get(key = FirstTestKey).value shouldBe SecondTestValue
    cache.length() shouldBe 1
  }

  it should "add multiple items to cache when within capacity" in {
    val cache = new Lesson6LRUCache(capacity = 2)

    cache.set(key = FirstTestKey, value = FirstTestValue)
    cache.get(key = FirstTestKey).value shouldBe FirstTestValue
    cache.length() shouldBe 1

    cache.set(key = SecondTestKey, value = SecondTestValue)
    cache.get(key = SecondTestKey).value shouldBe SecondTestValue
    cache.length() shouldBe 2
  }

  it should "evict old items when beyond capacity" in {
    val cache = new Lesson6LRUCache(capacity = 2)

    cache.set(key = FirstTestKey, value = FirstTestValue)
    cache.get(key = FirstTestKey).value shouldBe FirstTestValue
    cache.length() shouldBe 1

    cache.set(key = SecondTestKey, value = SecondTestValue)
    cache.get(key = SecondTestKey).value shouldBe SecondTestValue
    cache.length() shouldBe 2

    cache.set(key = ThirdTestKey, value = ThirdTestValue)
    cache.get(key = ThirdTestKey).value shouldBe ThirdTestValue
    cache.length() shouldBe 2

    cache.get(key = FirstTestKey) shouldBe None
  }

}
