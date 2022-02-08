# 문제

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:
```
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
```
Example 2:
```
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
```
Example 3:
```
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 ```

Constraints:
```
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 ```

Follow up: Can you come up with an algorithm that runs in O(m + n) time?

# 방법
2가지 방법으로 O(m+n)을 구현했다.
첫번째 방법은 억지로 num1 배열을 재구성하기 위해 임시 배열을 사용했다.
그 덕분에 코드도 엄청 난해하며 메모리 낭비가 크다.

1. 임시 배열에 기존 nums1 배열 원본 백업 하면서, nums2와 비교하며 억지로 nums1 재구성하는 방법
```
length = m + n
tmp = new int[length] // nums1 백업용 임시 배열

nums1Index = 0
nums2Index = 0
tmpIndex   = 0  // 임시 배열의 인덱스

// nums1 를 순회한다
while nums1Index < length

	// nums1를 m번만 tmp 배열에 복사한다
	if nums1Index < m then
    	tmp[nums1Index] = nums1[nums1Index] // copy
    else
    	tmp[nums1Index] = MAX_INTEGER // 0으로 채워진 공석을 최대 정수로 교체
    endif
    

	// tmp 배열과 nums2 배열 둘다 비교할 숫자가 남아 있다면, 더 작은 수를 nums1에 넣는다
	if tmpIndex < m and nums2Index < n then
    
    	if tmp[tmpIndex] < nums2[nums2Index] then
        	nums1[nums1Index] = tmp[tmpIndex]
            nums1Index++
            tmpIndex++
        else
        	nums1[nums1Index] = nums2[nums2Index]
            nums1Index++
            nums2Index++
        endif
        
    // tmp 배열과 nums2 배열 둘 중 한 배열만 남았다면 남은 숫자 다 채워준다
    elseif tmpIndex < m then
    	nums1[nums1Index] = tmp[tmpIndex]
        nums1Index++
        tmpIndex++
    else
    	nums1[nums1Index] = nums2[nums2Index]
        nums1Index++
        nums2Index++
    endif

endwhile
```

2. nums1과 nums2의 마지막 원소(두 배열의 각각 제일 큰 수)에서 시작해서 두 배열의 수를 비교하며 큰 숫자 순서대로 거꾸로 배열을 채워넣는 방법
```
nums1Index = m-1
nums2Index = n-1
pivot = m+n+-1

while 0 <= nums1Index and 0 <= nums2Index

	if nums1[nums1Index] > nums2[nums2Index]
    	nums1[pivot] = nums1[nums1Index]
        pivot--
        nums1Index--
    else
    	nums1[pivot] = nums2[nums2Index]
        pivot--
        nums2Index--
    endif

endwhile

while 0 <= nums1Index
    	nums1[pivot] = nums1[nums1Index]
        pivot--
        nums1Index--
endwhile

while 0 <= nums2Index
    	nums1[pivot] = nums2[nums2Index]
        pivot--
        nums2Index--
endwhile
```

# 구현(Java)
### 1

```
class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (n == 0) return;
        
        int length = m + n;
        int[] tmp = new int[length];
        
        int tmpIndex = 0, nums1Index = 0, nums2Index = 0;
        
        while (nums1Index < length) {
            
            tmp[nums1Index] = nums1Index < m? nums1[nums1Index]: Integer.MAX_VALUE;
            
            if (tmpIndex < m && nums2Index < n)
                nums1[nums1Index++] = tmp[tmpIndex] < nums2[nums2Index]?
                tmp[tmpIndex++]: nums2[nums2Index++];
                
            else if (tmpIndex < m)
                nums1[nums1Index++] = tmp[tmpIndex++];
                
            else // nums2Index < n
                nums1[nums1Index++] = nums2[nums2Index++];
        }
    }
}
```

### 2
```
class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index1 = m-1;
        int index2 = n-1;
        int index3 = m+n-1;
        
        while (0 <= index1 && 0 <= index2)
            nums1[index3--] = nums1[index1] > nums2[index2]? nums1[index1--]: nums2[index2--];
        
        while (0 <= index1) nums1[index3--] = nums1[index1--];
        while (0 <= index2) nums1[index3--] = nums2[index2--];
    }
}
```