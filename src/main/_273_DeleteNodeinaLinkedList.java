package main;


import main.domian.ListNode;

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
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4).setNext(
                (new ListNode(1)).setNext(
                        (new ListNode(5).setNext(
                                (new ListNode(4))
                        )
                        )
                ));

        ListNode.printVal(head);
        deleteNode(head.next.next);
        System.out.println();
        ListNode.printVal(head);
    }


}

