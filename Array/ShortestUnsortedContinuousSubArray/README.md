# 問題
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:
```
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
```
Example 2:
```
Input: nums = [1,2,3,4]
Output: 0
```
Example 3:
```
Input: nums = [1]
Output: 0
 ```

Constraints:
```
1 <= nums.length <= 104
-105 <= nums[i] <= 105
 ```

Follow up: Can you solve it in O(n) time complexity?

# 方法
O(nlogn)の時間計算量で具現すると難しい問題ではない。
しかしO(n)の時間計算量のアルゴリズムで具現するのは別の話だ。
入力した配列の数字を絵に描いて並びながら直観的な方法で近つける。

１。一度配列を巡回しながら、
直前の数字より低い数字が出る瞬間（落ちる時）に配列のminやmaxをアプデートする。
（この時に得られるminとmaxは配列全体のminやmaxではないことに気をつける。）

２。minとmaxを探すための巡回が終わったら、配列の中で、一番最初に得られるminより高い数字と一番最後に得られるmaxより低い数字のindexを探す

３。得られたindexを引くと整列対象の範囲になる。


# 具現 (Java)
```
import java.util.*;

class Solution {
    
    public int findUnsortedSubarray(int[] nums) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        
        for (int i = 0, pre = nums[0]; i < nums.length; pre = nums[i++]) {
            
            int num = nums[i];
            
            if (pre > nums[i]) {
                
                if (max <= pre) {
                    
                    max = pre;
                    right = i+1;
                }
                if (min > num)
                    min = num;
            }
        }
        
        while (left < right && nums[left] <= min) left++;
        while (right < nums.length && nums[right] < max) right++;
        
        return right-left;
    }
}
```