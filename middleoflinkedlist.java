package project190;

public class middleoflinkedlist {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }
    public static Node middleofLL(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[]args){
        Node a = new Node(3);
        Node b = new Node(2);
        Node c = new Node(6);
        Node d = new Node(7);
        Node e = new Node(8);
        Node f = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Node temp = a;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        Node middleNode = middleofLL(a);
        System.out.println("Middle Node of the linked list is "  + middleNode.data);
    }

    
}
