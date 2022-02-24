class Permute {
    private List<List<Integer>> res = new LinkedList<>();
    //DFS 
    public List<List<Integer>> permute(int[] nums) {
        //路径
        List<Integer> path = new LinkedList<>();
        backtrack(nums,path);
        return res;
    }

    public  void backtrack(int[] nums,List<Integer> path){
        //结束条件
        if(path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        //选择列表 
        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])){
                continue;
            }
            //选择路线 
            //将节点加入path中
            path.add(nums[i]);
            backtrack(nums,path);
            //撤销选择
            path.remove(path.size()-1);
        }
    }
}
