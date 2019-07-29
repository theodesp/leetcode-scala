import utest.{TestSuite, Tests, test}
object AddTwoNumbersTests extends TestSuite {
  val tests = Tests {
    test("empty input") {
      assert(AddTwoNumbers(null, null) == null)
      assert(AddTwoNumbers(null, new ListNode(2)).x == 2)
      assert(AddTwoNumbers(new ListNode(2), null).x == 2)
    }

    test("non empty input") {
      assert(AddTwoNumbers(new ListNode(2), new ListNode(2)).x == 4)
      val res1 = AddTwoNumbers(new ListNode(9), new ListNode(2))
      assert(res1.x == 1)
      assert(res1.next.x == 1)
      val l1 = new ListNode(2)
      l1.next = new ListNode(4)
      l1.next.next = new ListNode(3)
      val l2 = new ListNode(5)
      l2.next = new ListNode(6)
      l2.next.next = new ListNode(4)

      val res2 = AddTwoNumbers(l1, l2)
      assert(res2.x == 7)
      assert(res2.next.x == 0)
      assert(res2.next.next.x == 8)
    }
  }
}
