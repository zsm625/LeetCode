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
class RemoveElements {
    public ListNode RemoveElements(ListNode head, int val) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode pre = temp;
        while(head!=null){
            if(head.val==val){
                pre.next = head.next;
                head = head.next;
            }else{
                pre = head;
                head = head.next;
            }
        }
        return temp.next;
    }
}
