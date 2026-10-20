class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        recurse(nums, list, new ArrayList<>(), 0);

        return list;
    }

    private void recurse(int[] nums, List<List<Integer>> list, List<Integer> innerList, int index){
        if(index > nums.length) return;
        list.add(new ArrayList<>(innerList));

        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            innerList.add(nums[i]);
            recurse(nums, list, innerList, i+1);
            innerList.remove(innerList.size()-1);
        }
    }
}
