class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        LinkedList<Integer> trace = new LinkedList<>();
        backtrace(nums,0,trace);
        return res;
    }
    
    public void backtrace(int[] nums,int start,LinkedList<Integer> trace){
        res.add(new ArrayList<>(trace));
        for(int i=start;i<nums.length;i++){
            trace.addLast(nums[i]);
            backtrace(nums,i+1,trace);
            trace.removeLast();
        }
    }
}
