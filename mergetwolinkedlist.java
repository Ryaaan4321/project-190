package project190;

public class mergetwolinkedlist {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node dummy = new Node(-1);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Appending the remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(7);
        l1.next = a;
        a.next = b;
        b.next = c;

        Node l2 = new Node(2);
        Node d = new Node(4);
        Node e = new Node(6);
        Node f = new Node(8);
        l2.next = d;
        d.next = e;
        e.next = f;

        Node mergedList = mergeTwoLists(l1, l2);
        Node temp = mergedList;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
