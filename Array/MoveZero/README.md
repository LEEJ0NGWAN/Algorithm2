# 문제
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array. 

```
Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
```
<br/>

```
Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
```

# 방법

0이 아닌 숫자를 순서대로 앞으로 "복사"하고, 마지막으로 등장한 0이 아닌 숫자가 앞으로 땡겨진 위치의 다음위치부터 일괄적으로 0을 채워넣는다.

O(n)이 걸린다.
더 절약되는 스왑 방법이 있겠지만 쉽게 외우기에는 나한테 이 방법이 더 맞는 것 같다.

```
zeroIndex = 0

for i=0 to arrayLength-1
	if array[i] is not 0 then
    	array[zeroIndex] = array[i] // copy
        zeroIndex = zeroIndex + 1
    endif
endfor

while zeroIndex < arrayLength
	array[zeroIndex] = 0
    zeroIndex = zeroIndex + 1
endwhile

```

# 구현(Java)
```
class Solution {
    
    public void moveZeroes(int[] nums) {

        int j = 0;
        
        for (int i = 0; i < nums.length; i++) if (nums[i] != 0)
            nums[j++] = nums[i];
        
        while (j < nums.length) nums[j++] = 0;
    }
}
```