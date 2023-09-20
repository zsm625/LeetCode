/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> cacheMap = new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        //哈希+回溯
        if(head==null){
            return null;
        }
        if(!cacheMap.containsKey(head)){
            Node newNode = new Node(head.val);
            cacheMap.put(head,newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return cacheMap.get(head);
        
    }
}
