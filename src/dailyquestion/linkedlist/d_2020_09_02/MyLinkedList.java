package dailyquestion.linkedlist.d_2020_09_02;

import dailyquestion.ListNode;

/**
 * Design LinkedLit
 * Design your implementation of the linked list. 
 * You can choose to use the singly linked list 
 * or the doubly linked list. 
 * A node in a singly linked list should have two attributes:
 *  val and next. 
 *  val is the value of the current node, 
 *  and next is a pointer/reference to the next node. 
 *  If you want to use the doubly linked list, 
 *  you will need one more attribute prev to indicate the previous node 
 *  in the linked list. 
 *  Assume all nodes in the linked list are 0-indexed.
 * @author zsm
 *
 *     时间：2020年9月2日
 */
public class MyLinkedList {
	 /** Initialize your data structure here. */
    private ListNode head;
    private ListNode tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size=0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        ListNode node = head;
        while(index > 0){
            node = node.next;
            index--;
        }
        return node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        if(null == tail){
            tail = head;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {        
        if(head == null){
            addAtHead(val);
            return;
        }

        tail.next = new ListNode(val);
        tail = tail.next; 
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        ListNode node = head;
        ListNode newNode = new ListNode(val);
        while(null != node && index >1){
            node = node.next;
            index--;
        }
        newNode.next = node.next;
        node.next = newNode; 
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }
        if(index == 0){
            deleteAtHead();
            return;
        }
        ListNode node = head;
        while(null != node && index > 1){
            node = node.next;
            index--;
        }
        
        node.next = node.next.next;
        if(node.next == null){
            tail = node;
        }
        size--;
    }
    
    public void deleteAtHead(){
        head = head.next;
        size--;
    }
    
    public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtHead(1);
		list.addAtTail(3);
		list.addAtIndex(1, 2);
		int i = list.get(1);
		System.out.println(i);
		list.deleteAtIndex(1);
		list.get(1);
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

