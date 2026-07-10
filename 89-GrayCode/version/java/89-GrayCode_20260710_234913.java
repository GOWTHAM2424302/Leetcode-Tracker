// Last updated: 7/10/2026, 11:49:13 PM
1class Solution {
2    public List<List<Integer>> subsetsWithDup(int[] nums) {
3        List<List<Integer>> result = new ArrayList<>();
4        Arrays.sort(nums);
5        backtrack(0, nums, new ArrayList<>(), result);
6        return result;
7    }
8
9    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
10        result.add(new ArrayList<>(current));
11
12        for (int i = index; i < nums.length; i++) {
13            if (i > index && nums[i] == nums[i - 1]) {
14                continue;
15            }
16
17            current.add(nums[i]);
18            backtrack(i + 1, nums, current, result);
19            current.remove(current.size() - 1);
20        }
21    }
22}