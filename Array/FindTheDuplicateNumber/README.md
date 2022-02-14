# 문제
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:
```
Input: nums = [1,3,4,2,2]
Output: 2
```
Example 2:
```
Input: nums = [3,1,3,4,2]
Output: 3
 ```

Constraints:

- 1 <= n <= 105
- nums.length == n + 1
- 1 <= nums[i] <= n
- All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

- How can we prove that at least one duplicate number must exist in nums?
- Can you solve the problem in linear runtime complexity?

# 방법
여러가지 방법이 있겠지만 크게 3가지 방법으로 접근했다

### visit 체크 배열 사용
visit 체크를 하는 배열로 중복 숫자를 체크한다
- 시간 복잡도: O(n)
- 공간 복잡도: O(n) (새로운 배열을 만들어야 하기 때문)
- 문제의 조건(입력 배열 수정 X)을 위반하지 않음

### 음수 체크 사용
visit 체크 배열 대신 입력 받은 배열을 음수로 만들며 중복 여부를 체크한다
- 시간 복잡도: O(n)
- 공간 복잡도: O(1) (기존에 입력받은 배열로 알고리즘을 수행하기 때문)
- **문제의 조건(입력 배열 수정 X)를 위반**

### 플로이드 거북이 토끼 알고리즘 사용
플로이드의 거북이 토끼 알고리즘으로 그래프의 싸이클을 체크하고 시작점을 검사한다
- 시간 복잡도: O(n)
- 공간 복잡도: O(1) (상수 공간복잡도만 요구됨)
- 문제의 조건(입력 배열 수정 X)를 위반하지 않음

# 구현 (java)
### visit 체크 배열 사용
```
class Solution {
    
    public int findDuplicate(int[] nums) {
        
        final boolean[] visit = new boolean[nums.length];
        
        for (int num: nums)
            if (visit[num]) return num;
            else visit[num] = true;
        
        return 0;
    }
}

```

### 음수 체크 사용
class Solution {
    
    public int findDuplicate(int[] nums) {
        
        for (int num: nums)
            if (nums[(num = Math.abs(num))] < 0) return num;
            else nums[num] *= -1;
        
        return 0;
    }
}


### 플로이드 거북이 토끼 알고리즘 사용
```
class Solution {
    
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0], fast = nums[nums[0]];
        
        while (slow != fast) {
            
            slow = nums[slow];       // x1 speed
            fast = nums[nums[fast]]; // x2 speed
        }
        
        slow = 0;
        while (slow != fast) {
            
            slow = nums[slow]; // x1 speed
            fast = nums[fast]; // x1 speed
        }
        return slow;
    }
}

```