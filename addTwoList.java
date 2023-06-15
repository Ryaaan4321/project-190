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
        ListNode dummy = new ListNode(0); 
        ListNode temp = dummy; 
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0; 
            if(l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            }
            
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            
            sum += carry; 
            carry = sum / 10; 
            ListNode node = new ListNode(sum % 10); 
            temp.next = node; 
            temp = temp.next; 
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
    
