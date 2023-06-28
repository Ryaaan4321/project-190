package project190;

public class rotateNodesInKgroup {

 
public static class ListNode {
    int val;
    ListNode next;  
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k ==1) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode curr = temp , nex = temp ,  prev = temp;

        int count = 0;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }
        while(count >= k){
            curr = prev.next;
            nex = curr.next;
            for(int i = 1; i < k; i++){
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return temp.next;
        
        
    }
   public static void main(String[] args) {
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
    ListNode node6 = new ListNode(6);
    ListNode node5 = new ListNode(5, node6);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);

    int k = 3; // Reverse groups of 2 nodes

    ListNode reversed = reverseKGroup(node1, k) ;
    // Perform operations on the reversed linked list, if needed
    // ...
    while(reversed != null){
        System.out.print(reversed.val + " ");
        reversed = reversed.next;
    }
}

}

    

