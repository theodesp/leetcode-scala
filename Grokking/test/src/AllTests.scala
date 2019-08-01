import utest.{TestSuite, Tests, test}
object AllTests extends TestSuite {
  val tests = Tests {
    test("binary search") {
      assert(Ch1.binarySearch(List(1, 2, 5, 7, 9), 2) == 1)
      assert(Ch1.binarySearch(List(1, 2, 5, 7, 9), 3) == -1)
      assert(Ch1.binarySearch(List(1, 2, 5, 7, 9), 9) == 4)
    }

    test("selection sort") {
      assert(Ch2.selectionSort(List()).sameElements(List()))
      assert(Ch2.selectionSort(List(2)).sameElements(List(2)))
      assert(Ch2.selectionSort(List(3, 2)).sameElements(List(2, 3)))
      assert(
        Ch2
          .selectionSort(Array(5, 3, 6, 2, 10))
          .sameElements(List(2, 3, 5, 6, 10)))
    }

    test("quick sort") {
      assert(Ch4.quickSort(List()).sameElements(List()))
      assert(Ch4.quickSort(List(2)).sameElements(List(2)))
      assert(Ch4.quickSort(List(3, 2)).sameElements(List(2, 3)))
      assert(
        Ch4
          .quickSort(Array(5, 3, 6, 2, 10))
          .sameElements(List(2, 3, 5, 6, 10)))
    }
  }
}
