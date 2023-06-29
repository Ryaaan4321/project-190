package project190;

import java.util.*;

public class rotateLinkedlist {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode insertNode(ListNode head , int k){
        ListNode newNode = new ListNode(k);
            if (head == null) {
            head = newNode;
            return head;
           }
            ListNode temp = head;
            while (temp.next != null) temp = temp.next;

            temp.next = newNode;
            return head;
   }

  //utility function to rotate list by k times

  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    for (int i = 0; i < k; i++) {
      ListNode temp = head;
      while (temp.next.next != null) temp = temp.next;
      ListNode end = temp.next;
      temp.next = null;
      end.next = head;
      head = end;
    }
    return head;
  }
  //utility function to print list
  static void printList(ListNode head) {
    while (head.next != null) {
      System.out.print(head.val + "->");
      head = head.next;
    }
    System.out.println(head.val);

  }

  public static ListNode rotateRight1(ListNode head, int k) {
    if (head == null || k == 0) return head;

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
        ListNode head = null;
    //inserting elements in the head of the listheads
    head = insertNode(head, 1);
    head = insertNode(head, 2);
    head = insertNode(head, 3);
    head = insertNode(head, 4);
    head = insertNode(head, 5);

    System.out.println("Original list: ");
    printList(head);

    int k = 3;
    ListNode newHead = rotateRight1(head, k); //calling function for rotating 
   // right of the nodes by k times

    System.out.println("After " + k + " iterations: ");
    printList(newHead); //l
       
    }
}
