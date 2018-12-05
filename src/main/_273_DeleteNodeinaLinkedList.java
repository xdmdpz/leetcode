package main;

/**
 *
 */
public class _273_DeleteNodeinaLinkedList {
    /**
     * Definition for singly-linked list.
     * public class main.ListNode {
     * int val;
     * main.ListNode next;
     * main.ListNode(int x) { val = x; }
     * }
     */
    static  ListNode head = new ListNode(4).setNext(
            (new ListNode(1)).setNext(
                    (new ListNode(5).setNext(
                            (new ListNode(4))
                    )
                    )
            ));
    public static void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
    }

    public static void main(String[] args) {
        printVal(head);
        deleteNode(head.next.next);
        System.out.println();
        printVal(head);
    }

    public static void printVal(ListNode node) {
        System.out.println(node.val);
        if (node.next != null)
            printVal(node.next);
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}