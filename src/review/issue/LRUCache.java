class LRUCache {
    private Map<Integer,Node> map;
    private DoubleList cache;
    private int cap;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
        return -1;
        }
        
        // 将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
        // 删除旧的数据
        deleteKey(key);
        // 新插入的数据为最近使用的数据
        addRecently(key,value);
        return;
       }
        if (cap == cache.size()) {
        // 删除最久未使用的元素
        removeLeastRecently();
        }
       // 添加为最近使用的元素
       addRecently(key, value);
    }
    
    //将某个key提为最近使用
    private void makeRecently(int key){
        Node node = map.get(key);
        //先将key从链表中删除
        cache.remove(node);
        //再将key插入到尾部;
        cache.addLast(node);
    }
    
    //添加最近使用的元素
    private void addRecently(int key,int val){
        Node node = new Node(key,val);
        cache.addLast(node);
        map.put(key,node);
    }
    //删除元素
    private void deleteKey(int key){
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }
    //删除最久未使用的元素
    private void removeLeastRecently(){
        Node deleteNode = cache.removeFirst();
        
        map.remove(deleteNode.key);
    }
}

//定义一个Node节点
class Node{
    int key,val;
    Node pre,next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}

//定义双向链表
class DoubleList{
    private Node head,tail;
    private int size;
    
    public DoubleList(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.pre = head;
        this.size = 0;
    }
    //链表尾部添加元素 时间复杂度O(1)
    public void addLast(Node node){
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
        size++;
    }
    //移除某节点
    public void remove(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        size--;
    }
    
    //移除第一个节点 并返回该节点
    public Node removeFirst(){
        if(head.next==tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    
    public int size(){
        return size;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
