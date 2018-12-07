package main;

import main.domian.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _21_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).setNext(
                (new ListNode(2)).setNext(
                        (new ListNode(4).setNext(
                                (new ListNode(5))
                        )
                        )
                ));
        ListNode l2 = new ListNode(1)
                .setNext(new ListNode(3)
                        .setNext(new ListNode(6)
                                .setNext(new ListNode(7))
                        ));

        ListNode.printVal(new _21_MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }

    /**
     * 递归解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode listNode;
        if (l1.val > l2.val) {
            listNode = l2;
            listNode.next = mergeTwoLists(l1, l2.next);
        } else {
            listNode = l1;
            listNode.next = mergeTwoLists(l1.next, l2);
        }
        return listNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            return l2;
        }
        if (l2 == null ) {
            return l1;
        }
        ListNode merge = new ListNode(0);
        ListNode cur = merge;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }

        return merge.next;
    }
}
