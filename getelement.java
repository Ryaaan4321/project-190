package project190;

public class getelement {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class getelementmeth {
        Node head = null;
        Node tail = null;

        void insertAtHead(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
        }

        public int size() {
            int size = 0;
            Node temp = head;
            while (temp != null) {
                temp = temp.next;
                size++;
            }
            return size;
        }

        int idxValue(int idx) {
            if (idx < 0 || idx >= size()) {
                System.out.println("Invalid index!");
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getelementmeth gt = new getelementmeth();

        gt.insertAtHead(1);
        gt.insertAtHead(2);
        gt.insertAtHead(3);
        gt.insertAtHead(4);
        gt.insertAtHead(5);

        gt.display();

        int idx = 2;
        int value = gt.idxValue(idx);
        if (value != -1) {
            System.out.println("Value at index " + idx + ": " + value);
        }
    }
}
