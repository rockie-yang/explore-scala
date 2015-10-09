package ScalaTest

import collection.mutable
import org.scalatest._

import scala.collection.mutable.ListBuffer

class StackSpec extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new mutable.Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new mutable.Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}

class Similar2Junit extends FunSuite {
  test("the test name can have spaces") {

  }
}

//class SetSpec extends FunSpec {
//
//  describe("A Set") {
//    describe("when empty") {
//      it("should have size 0") {
//        assert(Set.empty.size == 0)
//      }
//
//      it("should produce NoSuchElementException when head is invoked") {
//        intercept[NoSuchElementException] {
//          Set.empty.head
//        }
//      }
//    }
//  }
//}

class ExampleSpec extends FunSpec with BeforeAndAfter {

  val builder = new StringBuilder
  val buffer = new ListBuffer[String]

  before {
    builder.append("ScalaTest is ")
  }

  after {
    builder.clear()
    buffer.clear()
  }

  describe("Testing") {
    it("should be easy") {
      builder.append("easy!")
      assert(builder.toString === "ScalaTest is easy!")
      assert(buffer.isEmpty)
      buffer += "sweet"
    }

    it("should be fun") {
      builder.append("fun!")
      assert(builder.toString === "ScalaTest is fun!")
      assert(buffer.isEmpty)
    }
  }
}

class SetSpec extends FunSpec {
  describe("A Set") {
    describe("when empty") {
      it("should have size 0") {
        assert(Set.empty.size == 0)
      }
      it("should produce NoSuchElementException when head is invoked") {
        intercept[NoSuchElementException]{
          Set.empty.head
        }
      }
    }
  }
}