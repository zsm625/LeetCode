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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode bigger = new ListNode(-1,head);       
        ListNode smaller = new ListNode(-1,head);
        ListNode b = bigger;
        ListNode s = smaller;
        ListNode ans = s;
        while(head!=null){
           if(head.val>=x){
               bigger.next = head;
               bigger= bigger.next;
           }else{
               smaller.next = head;
               smaller = smaller.next;
           }
           head = head.next;  
        }
        bigger.next = null;
        smaller.next = b.next;
        return ans.next;
    }
}
