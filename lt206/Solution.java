package lt206;

public class Solution {
    public static void main(String[] args) {

        ListNode head = createTestData();

        ListNode tmp = head;
        System.out.println("-----before-----");
        while (tmp!=null){
            System.out.println(tmp);
            tmp = tmp.next;
        }

        ListNode listNode = reverseList(head);
        ListNode tmpRes = listNode;

        System.out.println("-----reverse-----");
        while (tmpRes!=null){
            System.out.println(tmpRes);
            tmpRes = tmpRes.next;
        }

    }

    private static ListNode createTestData() {
        ListNode tail = new ListNode(5);
        ListNode node4 = new ListNode(4, tail);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        return head;
    }

    /**
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:41.1 MB,击败了76.45% 的Java用户
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode nextSavePoint;
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1.next = head;
        p2.next = head.next;
        head.next = null;
        while (p2.next!=null){
            nextSavePoint = new ListNode(p2.next.val,p2.next.next);
            p2.next.next = p1.next;
            p1.next = p2.next;
            p2.next = nextSavePoint.next;
        }

        return p1.next;
    }


}
