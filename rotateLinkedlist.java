package project190;

import java.util.Scanner;

public class rotateLinkedlist {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next != null || k == 0) return head;

        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            length++;
            curr = curr.next;
        }

        curr.next = head;
        k = length - k % length;
        while (k-- > 0) curr = curr.next;

        head = curr.next;
        curr.next = null;

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elements of the linked list separated by spaces: ");
        String[] elements = scanner.nextLine().split(" ");

        ListNode head = null;
        ListNode current = null;

        for (String element : elements) {
            int value = Integer.parseInt(element);
            ListNode node = new ListNode(value);

            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }
        }

        System.out.print("Enter the value of 'k': ");
        int k = scanner.nextInt();

        scanner.close();

        ListNode rotatedHead = rotateRight(head, k);

        // Print the rotated linked list
        while (rotatedHead != null) {
            System.out.print(rotatedHead.val + " ");
            rotatedHead = rotatedHead.next;
        }
    }
}
