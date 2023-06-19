package project190;

import java.util.*;
public class insertatend {
    public static class Node{
        int data ;
        Node next ;
        Node (int data){
            this.data = data;
        }
    }
    public static class insertend{
        Node head = null;
        Node tail = null;
         
        void insertinend(int val){
            Node temp = new Node(val);
            if(head == null){
                head = temp;
            }else{
                tail.next = temp;
            }
            tail = temp;
        }
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    }
    public static class insertatbegining{
        Node head = null; 
        Node tail = null;

        void insertatbegin(int val){
            Node temp = new Node(val);
            if(head == null){
                head =  tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }

        }
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
    public static class insertatanynode {
    Node head = null;
    Node tail = null;

    void insertAtanyidx(int idx, int val) {
        Node tt = new Node(val);
        if (head == null) {
            head = tt;
            tail = tt;
        } else {
            Node temp = head;
            for (int i = 1; i < idx - 1; i++) {
                temp = temp.next;
            }
            tt.next = temp.next;
            temp.next = tt;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public static void main(String[] args) {
    insertatanynode ll = new insertatanynode();
    Node a = new Node(5);
    Node b = new Node(3);
    Node c = new Node(6);
    Node d = new Node(8);

    a.next = b;
    b.next = c;
    c.next = d;

    ll.head = a; // Set the head of the linked list
    ll.tail = d; // Set the tail of the linked list

    System.out.println(a.data);
    ll.insertAtanyidx(3, 10);
    ll.display();
}

   


        //insertatbegining ll = new insertatbegining();
        //ll.insertatbegin(1);
        //ll.insertatbegin(2);
        //ll.insertatbegin(3);
        //ll.insertatbegin(4);
        //ll.insertatbegin(5);
        //ll.display();



        //insertend ll = new insertend();
        //ll.insertinend(5);
        //ll.insertinend(4);
        //ll.insertinend(3);
       // ll.insertinend(2);
        //ll.insertinend(1);
        
      //  ll.display();
    //}
    }

    

