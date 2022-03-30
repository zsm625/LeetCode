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
class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        for(int i=0;i<left-1;i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next ;
        for(int j=left;j<right;j++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

            
        }
        return dump.next;

    } 
}
