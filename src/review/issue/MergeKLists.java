/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size==0){
            return null;
        }
        if(size==1){
            return lists[0];
        }
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        ListNode list1 = lists[0];
        for(int i=1;i<size;i++){
            mergeTwoList(list1,lists[i],cur);
            list1 = res.next;
        }
        return res.next;
    }

    public void mergeTwoList(ListNode list1,ListNode list2,ListNode cur){
        while(list1!=null && list2!=null){
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1<=val2){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else{
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if(list1==null){
            cur.next = list2;
        }
        if(list2 == null){
            cur.next = list1;
        }
        cur = cur.next;
    }
  
  //优先队列 最小堆
   public ListNode mergeKLists1(ListNode[] lists) {
        int len = lists.length;
        if(len==0){
            return null;
        }
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        //优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len,(a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            cur.next = temp;
            if(temp.next!=null){
                queue.add(temp.next);
            }
            cur = cur.next;
        }

        return dump.next;
    }
}
