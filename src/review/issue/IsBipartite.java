class IsBipartite {
    
     //该图可能是一个有环图，所以需要加上visited来保存已经访问过的节点
    private boolean[] visited;
    //声明一个dyeing 染色
    private boolean[] dyeing ;
    private boolean isOk = true;
    public boolean isBipartite(int[][] graph) {
        //解题思路：
        int len = graph.length;
       visited = new boolean[len];
       dyeing = new boolean[len];
       for(int i=0;i<len;i++){
           if(!visited[i]){
               traver(graph,i);
           }
       }
       return isOk;
    }

    public void traver(int[][] graph,int v){
        //isOk=false 直接返回
        if(!isOk){
            return;
        }

        for(int s:graph[v]){
            //如果已经访问过的，判断染色情况
            if(visited[s]){
                //如果相邻的两个节点颜色一致，则不是二分图
                if(dyeing[s]==dyeing[v]){
                    isOk = false;
                }
            }else{
                visited[s] = true;
                dyeing[s] = !dyeing[v];
                traver(graph,s);
            }
        }

    }
}
