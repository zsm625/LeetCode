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
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while(list1!=null && list2!=null){
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1<=val2){
                res.next = list1;
                res = res.next;
                list1 = list1.next;
            }else{
                res.next = list2;
                res = res.next;
                list2 = list2.next;
            }
        }
        if(list1==null){
            res.next = list2;
        }
        if(list2==null){
            res.next = list1;
        }
        
        return cur.next;
        
    }
}
