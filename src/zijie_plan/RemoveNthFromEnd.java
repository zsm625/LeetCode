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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //暴力方式，先遍历一下拿到链表长度
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        
        ListNode cur = new ListNode(-1);
        cur.next = head;
        ListNode ans = cur;
        for(int i=0;i<len-n&&cur!=null;i++){
            cur = cur.next;
        }
        if(cur!=null&& cur.next!=null){
            cur.next = cur.next.next;
        }
        return ans.next;
    }
}
