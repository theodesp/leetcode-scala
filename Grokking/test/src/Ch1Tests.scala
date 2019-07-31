import utest.{TestSuite, Tests, test}
object Ch1Tests extends TestSuite {
  val tests = Tests {
    test("binary search") {
      assert(Ch1.binarySearchRec(List(1, 2, 5, 7, 9), 2) == 1)
      assert(Ch1.binarySearchRec(List(1, 2, 5, 7, 9), 3) == -1)
      assert(Ch1.binarySearchRec(List(1, 2, 5, 7, 9), 9) == 4)
    }
  }
}
