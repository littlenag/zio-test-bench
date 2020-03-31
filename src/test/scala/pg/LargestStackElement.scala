package pg

import org.junit.Test
import org.junit.runner.JUnitCore
import org.junit.runner.Result
import org.junit.runner.notification.Failure
import org.junit.Assert._

import scala.collection.mutable


object Solution { // fill in the definitions for push(), pop(), and getMax()
  class MaxStack {

    import scala.collection.mutable._

    var stack = List.empty[Int]

    def push(item: Int): Unit = {
      stack = item :: stack
    }

    def pop = stack match {
      case head :: tail => stack = tail; head
      case Nil => throw new RuntimeException("Empty stack")
    }

    def getMax = stack.max
  }

  // tests
  def main(args: Array[String]): Unit = {
    val result = JUnitCore.runClasses(classOf[Solution])
    import scala.collection.JavaConversions._
    for (failure <- result.getFailures) {
      System.out.println(failure.toString)
    }
    if (result.wasSuccessful) System.out.println("All tests passed.")
  }
}

class Solution {
  @Test def maxStackTest(): Unit = {
    val s = new Solution.MaxStack
    s.push(5)
    assertEquals("check max after 1st push", 5, s.getMax)
    s.push(4)
    s.push(7)
    s.push(7)
    s.push(8)
    println("foo")
    assertEquals("check before 1st pop", 8, s.getMax)
    assertEquals("check pop #1", 8, s.pop)
    assertEquals("check max after 1st pop", 7, s.getMax)
    assertEquals("check pop #2", 7, s.pop)
    assertEquals("check max after 2nd pop", 7, s.getMax)
    assertEquals("check pop #3", 7, s.pop)
    assertEquals("check max after 3rd pop", 5, s.getMax)
    assertEquals("check pop #4", 4, s.pop)
    assertEquals("check max after 4th pop", 5, s.getMax)
  }
}