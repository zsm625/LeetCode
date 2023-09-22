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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur = new ListNode(-1);
        cur.next = head;
        ListNode ans = cur;
        while(cur.next!=null && cur.next.next !=null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next!=null && cur.next.val==x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return ans.next;
    }
        
}
