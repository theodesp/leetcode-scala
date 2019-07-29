import scala.annotation.tailrec

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

  Example:

  Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

object TwoSum extends App {
  def apply(nums: Array[Int], target: Int): Array[Int] = twoSum(nums, target)
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    if (nums.length < 2)
      Array.empty[Int]
    else {
      (for {
        i <- nums.indices.toArray
        j <- nums.indices.reverse.toArray
        if i < j
        if nums(i) + nums(j) == target
      } yield (i, j)) flatMap {
        case (a, b) => List(a, b)
      }
    }
  }
  def twoSum2(nums: Array[Int], target: Int): Array[Int] = {
    if (nums.length < 2)
      Array.empty[Int]
    else
      twoSumIter(nums, target, 0, 1, Array.empty[Int])
  }
  @tailrec
  def twoSumIter(nums: Array[Int],
                 target: Int,
                 start: Int,
                 end: Int,
                 result: Array[Int] = Array.empty[Int]): Array[Int] = {
    if (start == nums.length - 1) {
      result
    } else {
      if (nums(start) + nums(end) == target) {
        Array(start, end)
      } else {
        if (end == nums.length - 1) {
          twoSumIter(nums, target, start + 1, start + 2, result)
        } else {
          twoSumIter(nums, target, start, end + 1, result)
        }
      }
    }
  }
  def twoSum3(nums: Array[Int], target: Int): Array[Int] = {
    if (nums.length < 2)
      Array.empty[Int]
    else {
      // Converts list to map as (element -> index)
      val lookup = nums.zipWithIndex.map {
        case (element, index) => element -> index
      }.toMap
      twoSumIter2(nums, target, lookup, 0)
    }
  }
  @tailrec
  def twoSumIter2(nums: Array[Int],
                  target: Int,
                  lookup: Map[Int, Int],
                  idx: Int): Array[Int] = {
    if (idx == nums.length - 1) {
      Array.empty[Int]
    } else {
      val complement = target - nums(idx)
      if (lookup.contains(complement) && lookup(complement) != idx) {
        Array(idx, lookup(complement))
      } else
        twoSumIter2(nums, target, lookup, idx + 1)
    }
  }
}
