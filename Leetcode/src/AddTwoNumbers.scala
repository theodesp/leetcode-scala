class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}
object AddTwoNumbers extends App {
  def apply(l1: ListNode, l2: ListNode): ListNode = {
    var result = new ListNode(0)
    var carry = 0
    var left = l1
    var right = l2
    var curr = result
    while (left != null || right != null) {
      val x = if (left != null) left.x else 0
      val y = if (right != null) right.x else 0
      val sum = carry + x + y
      carry = sum / 10
      curr.next = new ListNode(sum % 10)
      curr = curr.next
      if (left != null)
        left = left.next
      if (right != null)
        right = right.next
    }
    if (carry > 0)
      curr.next = new ListNode(carry)
    result.next
  }
}
