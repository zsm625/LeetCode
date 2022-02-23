class AllPathsSourceTarget {
    private List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //题目给定的是一个有向无环图，也就无需visited 保存访问走过的路径
        //定义一个onPath记录当前访问过的节点
        LinkedList<Integer> onPath = new LinkedList<>();
        traver(graph,0,onPath);
        return res;
    }

    public void traver(int[][] graph,int i,LinkedList<Integer> onPath){
         //图的遍历框架
        //维护onPath 进入遍历方法时就将节点加入的onPath中，
        //如果节点 i==图的长度时就说明到达终点了
        //到达终点就将此条路线放入结果集中，并从onPath中将节点i移除
        //循环遍历节点i相邻的节点，并递归遍历
        //每次递归返回后还需将该节点移除onPath
        onPath.addLast(i);
        int len = graph.length;
        if(i==len-1){
            res.add(new ArrayList<>(onPath));
            onPath.removeLast();
            return;
        }
        for(int v:graph[i]){
            traver(graph,v,onPath);
        }
        onPath.removeLast();
    }
}
