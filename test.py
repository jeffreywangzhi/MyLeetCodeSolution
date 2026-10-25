from collections import Counter
from collections import defaultdict
# Definition for singly-linked list.
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]) -> TreeNode | None:
        if len(preorder) <= 0 or len(inorder) <= 0: return None
        cur = preorder[0]
        root = TreeNode(cur)
        for i, val in enumerate(inorder):
            if val == cur: break
        root.left = self.buildTree(preorder[1:],inorder[0:i])
        root.right = self.buildTree(preorder[2:],inorder[i+1:])
        return root
    
# ==========================================
# LOCAL TESTING UTILITIES
# ==========================================

def run_tests():
    preorder = [1,2]
    inorder = [1,2]
    # Test 1: Standard case (342 + 465 = 807)
    sol = Solution()
    r = sol.buildTree(preorder,inorder)
    
    print(r)

if __name__ == "__main__":
    run_tests()