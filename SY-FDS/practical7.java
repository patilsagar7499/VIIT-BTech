public class practical7 {
    class Node{
        int data;
        Node previous;
        Node next;
        public Node(int data)
        {
            this.data=data;
        }
    }
    Node head,tail=null;
    public void addNode(int data){
        Node newNode=new Node(data);
        if(head==null)
        {
            head=tail=newNode;
            head.previous=null;
            tail.next=null;
        }
        else{
            tail.next=newNode;
            newNode.previous=tail;
            tail=newNode;
            tail.next=null;
        }
    }
    public void reverse()
    {
        Node current=head,temp=null;
        while(current!=null)
        {
            temp=current.next;
            current.next=current.previous;
            current.previous=temp;
            current=current.previous;
        }
        temp=head;
        head=tail;
        tail=temp;
    }
    public void display()
    {
        Node current=head;
        if (head==null)
        {
            System.out.println("List is empty");
            return;
        }
        while(current!=null)
        {
            System.out.println(current.data+"");
            current=current.next;
        }
    }
    public static void main(String[] args)
    {
        practical7 dlist=new practical7();
        dlist.addNode(1);
        dlist.addNode(2);
        dlist.addNode(3);
        dlist.addNode(4);
        dlist.addNode(5);
        System.out.println("Original List:");
        dlist.display();
        dlist.reverse();
        System.out.println("\nReversed List:");
        dlist.display();
    }
}
