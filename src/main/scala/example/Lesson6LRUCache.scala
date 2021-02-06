package example

import scala.collection.immutable.ListMap

class Lesson6LRUCache(capacity: Int) {

  private var cache = ListMap.empty[String, String]

  def get(key: String): Option[String] = synchronized {
    cache.get(key).map { entryValue =>
      cache += (key -> entryValue)
      entryValue
    }
  }

  def set(key: String, value: String): Unit = synchronized {
    if (cache.size < capacity) cache += (key -> value)
    else {
      cache = cache.tail
      cache += (key -> value)
    }
  }

  def length(): Int = synchronized { cache.size }

}
