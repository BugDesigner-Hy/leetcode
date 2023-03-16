package lt146;

/**
 * 双向链表的简单实现
 */
public class DoubleList {

    public static void main(String[] args) {
        DoubleList list = new DoubleList();
        list.add(new Node(1,1));
        list.add(new Node(2,2));
        list.add(new Node(3,3));
        list.add(new Node(4,4));
        list.removeFirstNode();
        list.remove(list.getLastNode());
        list.size();
        System.out.println(list);
    }

    public static class Node {
        private int k, v;
        public Node pre, next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private Node head = new Node(0, 0);

    private Node tail = new Node(0, 0);

    private int size = 0;

    public DoubleList() {
        head.next = tail;
        tail.pre = head;
    }


    public void add(Node x) {
        x.pre = tail.pre;
        x.next = tail;
        tail.pre.next = x;
        tail.pre = x;
        size++;
    }

    public void remove(Node x) {
        if(x.pre==null && x.next==null){
            return;
        }
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    public Node removeFirstNode() {
        if (head.next == null) {
            return null;
        }
        Node firstNode = head.next;
        remove(firstNode);
        return firstNode;
    }

    public Node getLastNode(){
        return tail.pre;
    }

    public Node getFirstNode(){
        return head.next;
    }

    public int size() {
        return size;
    }

}
