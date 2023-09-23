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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int len = 0;
        ListNode curTemp = head;
        while(curTemp!=null){
            curTemp = curTemp.next;
            len++;
        }
        ListNode cur = head;
        ListNode post = null;
        // 计算需要往前走多少步
        int step = len-(k%len);
        ListNode pre = cur;
        ListNode ans = new ListNode(-1);
        
        while(cur!=null){
            if(step==1){
                post = cur.next;
                cur.next = null;
                break;
            }
            cur = cur.next;
            step--;
        }
        ans.next = post;
        while(post != null && post.next!=null){
            post = post.next;
        }
        if(post!=null){
            post.next = pre;
        }else{
            ans.next = pre;
        }
        return ans.next;

    }
    public ListNode rotateRight2(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int len = 0;
        ListNode curTemp = head;
        while(curTemp!=null){
            curTemp = curTemp.next;
            len++;
        }
        ListNode cur = head;
        // 计算需要往前走多少步
        int step = len-(k%len);
        //将链表先连成环，再根据需要走到step步处断开环
        while(cur!=null && cur.next!=null){
            cur = cur.next;
        }
        cur.next = head;
        ListNode ans = cur;
        for(int i=0;i<step;i++){
            cur = cur.next;
        }
        ans = cur.next;
        cur.next = null;
        return ans;

    }
}
