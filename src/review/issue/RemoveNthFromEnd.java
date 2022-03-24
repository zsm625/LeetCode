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
class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode cur = dump;
        for(int i=1;i<len-n+1;++i){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dump.next;
    }
}
