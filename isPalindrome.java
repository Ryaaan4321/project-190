package project190;



public class isPalindrome {
    public static class  ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
    public  static boolean islistPalind(ListNode head){
        if(head == null || head.next == null)  return true;

        ListNode slow = head;
        ListNode fast = head;
        
       // finding middle of the linkedlist  
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //once we find out the middle of the linked list then we reversed the second half of the linkedlist
        // or we can say the right half of the linked list
        // For ex - ( 1 -> 2 -> 3 -> 3 -> 2  -> 1)
        // we reversed the right half of the linked list
        
        slow.next = reverseList(slow.next);
        // now the linked list is after executing this method is (1 -> 2 -> 3 -> 1 -> 2 -> 3)

        slow = slow.next;
        // now we took one another pointer head to traverse on the left side of the linkedlist and
        // comparing it with the right half of the linkedlist bcs the slow pointer is in the right half at
        //index 3  will compare both of the pointers if they are equal it will return true otherwise false
        // and will compare both of them untill slow reaches to null;

        while(slow != null){
            if(head.val != slow.val){
                return false;

            }
            else{
                head = head.next;
                slow = slow.next;
            }
        }
        return true;

    }
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head; 
            head = next;
        }
        return pre;
    }
    public static void main(String[]args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;


        ListNode temp = a;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        boolean  palindrome = islistPalind(e);
        System.out.println("This linked list is palindrome " + palindrome + "statement");


    }
}
    

