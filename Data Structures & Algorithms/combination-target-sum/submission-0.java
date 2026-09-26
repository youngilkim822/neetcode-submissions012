class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        recurse(nums, list, new ArrayList<>(), target, 0, 0);
        return list;
    }

    private void recurse(int[] nums, List<List<Integer>> list, List<Integer> innerList, int target, int index, int sum){
        if(sum == target){
            list.add(new ArrayList<>(innerList));
            return;
        }else if(sum > target){
            return;
        }

        if(index == nums.length){
            return;
        }

        for(int i=index; i<nums.length; i++){
            innerList.add(nums[i]);
            recurse(nums, list, innerList, target, i, sum+nums[i]);
            innerList.remove(innerList.size()-1);
        }
    }
}
