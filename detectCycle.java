package project190;

public class detectCycle {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    
    
    }
    public static ListNode detectCyccle(ListNode head){
        if(head == null || head.next == null)
        return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode vella = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next ;
            fast = fast.next.next;
            if(slow == fast){
                while(slow != vella){
                    slow = slow.next;
                    vella = vella.next;
                }
                return vella;
            }
        }
        return null;
    }
    
    public static void printList(ListNode head){
        while(head.next != null){
            System.out.print(head.val +  " -> ");
            head = head.next;
        }
       System.out.println(head.val);
    }
    public static void main(String[] args) {
    ListNode a = new ListNode(5);
    ListNode b = new ListNode(3);
    ListNode c = new ListNode(6);
    ListNode d = new ListNode(8);

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = b;//  creating a cycle by connecting the current  nodes to the previous nodes

    ListNode cycleNode = detectCyccle(d);
    if (cycleNode != null) {
        System.out.println("Cycle detected at node with value: " + cycleNode.val);
    } else {
        System.out.println("No cycle detected.");
    }
}

    
}
