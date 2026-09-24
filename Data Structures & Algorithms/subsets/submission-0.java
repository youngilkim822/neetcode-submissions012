class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        recurse(nums, list, new ArrayList<>(), 0);
        return list;
    }

    private void recurse(int[] nums, List<List<Integer>> list, List<Integer> innerList, int k){
        list.add(new ArrayList<>(innerList));
        for(int i=k; i<nums.length; i++){
            innerList.add(nums[i]);
            recurse(nums, list, innerList, i+1);
            innerList.remove(innerList.size()-1);
        }
    }
}
