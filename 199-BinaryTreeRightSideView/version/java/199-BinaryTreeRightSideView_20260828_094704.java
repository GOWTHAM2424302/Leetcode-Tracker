// Last updated: 8/28/2026, 9:47:04 AM
1public class Solution {
2    public List<Integer> rightSideView(TreeNode root) {
3        List<Integer> result = new ArrayList<Integer>();
4        rightView(root, result, 0);
5        return result;
6    }
7    
8    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
9        if(curr == null){
10            return;
11        }
12        if(currDepth == result.size()){
13            result.add(curr.val);
14        }
15        
16        rightView(curr.right, result, currDepth + 1);
17        rightView(curr.left, result, currDepth + 1);
18        
19    }
20}