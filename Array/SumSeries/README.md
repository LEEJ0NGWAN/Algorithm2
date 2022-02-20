# 問題
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:
```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```
Example 2:
```
Input: nums = [0,0,0], target = 1
Output: 0
 ```

Constraints:
- 3 <= nums.length <= 1000
- -1000 <= nums[i] <= 1000
- -104 <= target <= 104


# 方法
最初は単純にdfsで問題を解く方法を悩んでいたが、問題の条件（配列の長さは１０００まで）を考えると時間計算量はO(n^3)まで上がるため効率が良くないと判断した。
幸にdfsの方法で提出するとAcceptedはできたが１５００msくらいの性能であんまり良くない結果が出た。それに比べると２回目で考えた２ポインター方法を実装すると、5msくらいでdfsよりもっと良い性能を確認できた。

### DFS
O(n^3)
再帰関数を作成して、配列から数字を三つ選ぶまで関数を繰り返す。繰り返して一番目標数字に近い和を救う。

### 2 pointer
O(n^2)
一度整列した配列を巡回しながら基準になる数字の右の数字（基準より大きい数字）の中で一番小さい数字と一番大きい数字を２ポインターに設定して目標数字に一番近い和があるかチェックしてゆく。


# 具現 (Java)
### DFS
O(n^3)
再帰関数を作成して、配列から数字を三つ選ぶまで関数を繰り返す。繰り返して一番目標数字に近い和を救う。
```
class Solution {
    
    private int dfs(int[] nums, int index, int count, int target, int sum, int ans) {
        
        if (count == 3) return Math.abs(target - sum) < Math.abs(target - ans)? sum: ans;
        
        for (int i = index; i < nums.length; i++)
        ans = dfs(nums, i+1, count+1, target, sum + nums[i], ans);
        
        return ans;
    }
    
    public int threeSumClosest(int[] nums, int target) {
        
        return dfs(nums, 0, 0, target, 0, 5000);
    }
}
```
### 2 pointer
O(n^2)
一度整列した配列を巡回しながら基準になる数字の右の数字（基準より大きい数字）の中で一番小さい数字と一番大きい数字を２ポインターに設定して目標数字に一番近い和があるかチェックしてゆく。

```
import java.util.Arrays;

class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int sum = Integer.MAX_VALUE, sum_diff = Integer.MAX_VALUE;
        
        loop:
        for (int i = 0, len = nums.length-2; i < len; i++) {
            
            int l = i+1, r = nums.length-1;
            
            while (l < r) {
                
                final int tmp = nums[i] + nums[l] + nums[r];
                final int tmp_diff = Math.abs(target - tmp);
                
                if (tmp_diff < sum_diff) {
                    
                    sum = tmp; sum_diff = tmp_diff;
                }
                
                if (tmp == target) break loop;
                else if (tmp < target) l++;
                else /* tmp > target*/ r--;
            }
        }
        
        return sum;
    }
}
```
