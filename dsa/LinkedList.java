import java.util.Objects;

class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

public class LinkedList {

    ListNode head;

    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (this.isEmpty()) {
            this.head = newNode;
            return;
        }
        ListNode curr = this.head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(newNode);
    }

    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    public void printList() {
        if (this.isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        ListNode curr = this.head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.printList();

    }
}
