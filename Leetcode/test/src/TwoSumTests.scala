import utest.{TestSuite, Tests, test}

object TwoSumTests extends TestSuite {
  val tests = Tests {
    test("empty input") {
      assert(TwoSum(Array(), 9) sameElements Array.empty[Int])
    }
    test("one element array") {
      assert(TwoSum(Array(9), 9) sameElements Array.empty[Int])
      assert(TwoSum(Array(5), 9) sameElements Array.empty[Int])
    }
    test("two element array") {
      assert(TwoSum(Array(11, 12), 9) sameElements Array.empty[Int])
      assert(TwoSum(Array(4, 5), 9) sameElements Array(0, 1))
      assert(TwoSum(Array(9, 10), 9) sameElements Array.empty[Int])
    }
    test("2+ element array") {
      assert(TwoSum(Array(2, 7, 11, 15), 9) sameElements Array(0, 1))
    }
  }
}
