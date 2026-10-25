from collections import Counter
from typing import List
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        bucket = [[] for i in range(len(nums)+1)]
        for num, freq in count.items(): bucket[freq].append(num)
        res = []
        for i in range(len(nums)+1, -1, -1):
            if len(res) >= k: break
            for j in bucket[i]: res.append(j)
        return res

if __name__ == "__main__":
    func = Solution()
    nums = [1,1,1,2,2,3]
    k = 2
    print(func.topKFrequent(nums,k))