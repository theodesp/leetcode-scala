import utest.{TestSuite, Tests, test}
object LongestSubstringNonRepeatingTests extends TestSuite {
  val tests = Tests {
    test("empty string") {
      assert(LongestSubstringNonRepeating("") == 0)
    }
    test("all chars the same string") {
      assert(LongestSubstringNonRepeating("ffffff") == 1)
    }
    test("no repeating chars") {
      assert(LongestSubstringNonRepeating("abcdefg") == 7)
    }
    test("some repeating chars") {
      assert(LongestSubstringNonRepeating("abcabcbb") == 3)
      assert(LongestSubstringNonRepeating("pwwkew") == 3)
    }
  }
}
