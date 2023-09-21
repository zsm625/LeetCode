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
    public ListNode reverseKGroup(ListNode head, int k) {
        //遍历一下得到链表长度
        ListNode node = head;
        int len = 0;
        while(node!=null){
            node = node.next;
            len++;
        }
        //根据长度查询需要翻转几组
        int g = len/k;
        ListNode ans = new ListNode(-1);
        ans.next = head;
        ListNode pre = ans;
        for(int i=1;i<=g;i++){
            ListNode cur = pre.next;
            int j = 1;
            ListNode next ;
            while(cur!=null && j<k){
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                j++;
            }
            pre = cur;
        }
        return ans.next;
    }
}
