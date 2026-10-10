class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        recurse(nums, list, new ArrayList<>(), set, 0);
        
        return list;
    }

    private void recurse(int[] nums, List<List<Integer>> list, List<Integer> innerList, Set<Integer> set, int index){
        if(index == nums.length){
            list.add(new ArrayList<>(innerList));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) continue;

            set.add(nums[i]);
            innerList.add(nums[i]);

            recurse(nums, list, innerList, set, index+1);

            innerList.remove(innerList.size()-1);
            set.remove(nums[i]);
        }
    }
}
