package project190;

public class removenthend {
    public static class Node{
        int data;
        Node next;

        Node (int data) {
            this .data = data;
        }  


    }
    public static Node remoNode(Node head , int n){

        if(head == null || n < 0 ){
            return head;

        }
        Node starter = new Node(0);
        starter.next = head;

        Node fast = starter;
        Node slow = starter;

        for(int i = 0 ; i < n ; i++){
            fast = fast.next;
            if ( fast == null) return head;
            
        }
        while(fast.next != null && slow.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return starter.next;

    }

    public static void main(String[]args){
        int n = 3;
        Node l1 = new Node(5);
        Node a = new Node(3);
        Node b = new Node(2);
        Node c = new Node(6);
        Node d = new Node(7);
        Node e = new Node(4);

        l1.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        Node deletionn = remoNode(l1, n);
        Node temp = deletionn;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
     
    }

    
}
