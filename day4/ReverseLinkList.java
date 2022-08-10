package day4;
class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkList {

    public static void main(String[] args){
        ListNode list = new ListNode();
        list.val = 85;
        list.next = new ListNode(15);
        list.next.next = new ListNode(4);
        list.next.next.next = new ListNode(20);
        ListNode a=list;
        System.out.print("Given:");
        while(a!=null) {
            System.out.print(a.val+" ");
            a=a.next;
        }
        a= reverseList(list);
        System.out.print("\nResult:");
        while(a!=null) {
            System.out.print(a.val+" ");
            a=a.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
}
