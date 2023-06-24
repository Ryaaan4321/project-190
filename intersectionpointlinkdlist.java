package project190;

import java.util.*;

public class intersectionpointlinkdlist {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;

        // Calculate the lengths of both linked lists
        while (a != null) {
            lenA++;
            a = a.next;
        }

        while (b != null) {
            lenB++;
            b = b.next;
        }

        // Reset the pointers to the heads of the linked lists
        a = headA;
        b = headB;

        // Adjust the starting point of the longer linked list
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                a = a.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;
            while (diff > 0) {
                b = b.next;
                diff--;
            }
        }

        // Traverse both linked lists until intersection point is found
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        intersectionpointlinkdlist solution = new intersectionpointlinkdlist();

        // Creating the first linked list: 3 -> 6 -> 9 -> 15 -> 30
        ListNode headA = solution.new ListNode(3);
        headA.next = solution.new ListNode(10);
        headA.next.next = solution.new ListNode(9);
        headA.next.next.next = solution.new ListNode(11);
        headA.next.next.next.next = solution.new ListNode(30);

        // Creating the second linked list: 10 -> 15 -> 30
        ListNode headB = solution.new ListNode(10);
        headB.next = solution.new ListNode(14);
        headB.next.next = solution.new ListNode(30);

        // Set intersection point of the two linked lists
      

        // Find the intersection point
        ListNode intersection = solution.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Point: " + intersection.val);
        } else {
            System.out.println("No intersection point found.");
        }
    }
}
