package project190;



public class addtwonumbers {
    public static class ListNode{
        
        int val;
        ListNode next;

        ListNode (int val){
            this.val = val;
        }
    }
    public static ListNode addtwonum(ListNode l1 ,ListNode l2){
        ListNode dummy = new ListNode(0); // Created a new dummy nnode to store the values of the sum f the linkedlist
        ListNode temp = dummy; // initialized  the head of tht dummy node with temp
        int carry = 0; // intialized the values of carry as a = 0
        
        while( l1 != null || l2 != null || carry == 1) { 
        // and now unitll if any of this three conditions are true running the loop
            int sum = 0; 
            if(l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            }
            
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            
            sum += carry;  // adding the values of carry in sum if we have..
            carry = sum / 10; // checking if we have a another carry when we added the diff elements from the list1 and list2
            ListNode node = new ListNode(sum % 10); // storing the modulo value into it 
            temp.next = node; // now connecting with tht node..
            temp = temp.next; // and moving tht temp pointer with th help of which we can form the linked list
        }
        return dummy.next;
    }
    public static void main(String[]args){
        ListNode l1 = new ListNode(3);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(6);

        l1.next = a;
        a.next = b;
        b.next = c;

        ListNode l2 = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        // ListNode g = new ListNode(9);

        l2.next =  d;
        d.next  =  e;
        e.next  =  f;
        
        
        ListNode sum = addtwonum(l1, l2);
        ListNode temp = sum;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }
}
    
