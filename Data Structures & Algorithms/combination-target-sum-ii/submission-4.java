class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        recurse(candidates, list, new ArrayList<>(), target, 0, 0);
        return list;
    }

    private void recurse(int[] candidates, List<List<Integer>> list, List<Integer> innerList, int target, int sum, int index){
        if(sum > target){
            return;
        }
        if(sum == target){
            if(list.contains(innerList)) return;
            list.add(new ArrayList<>(innerList));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]) continue;
            if(sum + candidates[i] > target) break;
            innerList.add(candidates[i]);
            recurse(candidates, list, innerList, target, sum+candidates[i], i+1);
            innerList.remove(innerList.size()-1);
        }
    }
}
