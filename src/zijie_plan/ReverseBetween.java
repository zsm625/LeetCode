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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        for(int i=1;i<left;i++){
            pre = pre.next;
        }
        //
        ListNode cur = pre.next;
        ListNode next;
        for(int i=left;i<right;i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return result.next;
    }
}
