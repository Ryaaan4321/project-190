package project190;

import java.util.*;

public class intersectionpointlinkdlist {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode commonNode = new ListNode(9);

        ListNode headANode = new ListNode(6);
        ListNode a = new ListNode(13);
        ListNode b = new ListNode(12);
        ListNode c = new ListNode(7);
        headANode.next = a;
        a.next = b;
        b.next = c;
        c.next = commonNode;

        ListNode headBListNode = new ListNode(4);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);
        headBListNode.next = d;
        d.next = e;
        e.next = commonNode;

        ListNode intersectionP = getIntersectionNode(headANode, headBListNode);

        if (intersectionP != null) {
            System.out.println("Intersection Point: " + intersectionP.val);
        } else {
            System.out.println("No intersection point found.");
        }
    }
}
