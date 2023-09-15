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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //用来记录超十的倍数
        int k = 0;
        ListNode guard = new ListNode(-1);
        ListNode result = guard;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+k;
            int val = sum%10;
            k = sum/10;
            guard.next = new ListNode(val);
            guard = guard.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val+k;
            int val = sum%10;
            k = sum/10;
            guard.next = new ListNode(val);
            guard = guard.next;
            l1 = l1.next;
        }
        while(l2!=null){
             int sum = l2.val+k;
            int val = sum%10;
            k = sum/10;
            guard.next = new ListNode(val);
            guard = guard.next;
            l2 = l2.next;
        }
        if(k!=0){
            guard.next = new ListNode(k);
        }
        return result.next;
    }
}
