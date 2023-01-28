
import java.util.Scanner;
class Stack{
    class Node{
        int data;
        Node next;
        Node(int d)
        {
            this.data=d;
        }
    }
    Node top;
    Stack()
    {
      this.top=null;
    }
    void push(int d)
    {
        Node temp=new Node(d);
        
        temp.next=top;
        top=temp;
    }
    boolean isempty()
    {
        if(top==null)
        return true;
        else
        return false;
    }
    void pop()
    {
        if(this.isempty())
        System.out.println("Underflow");
        else
        System.out.println("Popped:"+this.top.data);
        top=top.next;
    }
    void display()
    {
        Node temp=this.top;
        if(this.isempty())
        System.out.println("Stack is empty");
        else{
       while(temp!=null)
       {
        System.out.println("Element:"+temp.data);
        temp=temp.next;
       }
    }
    }

}

public class Assign5 {
    public static void main(String[] args)
    {
         Scanner sc=new Scanner(System.in);
         Stack s=new Stack();
         int choice;
         do{
         System.out.println("Enter the choice:1)Push,2)Pop,3)Display,4)Exit");
         choice=sc.nextInt();
         switch(choice)
         {
             case 1:
             int d;
             System.out.println("Enter the no.:");
             d=sc.nextInt();
             s.push(d);
             break;
             case 2:
             s.pop();
             break;
             case 3:
             s.display();
             break;
         }
         }while(choice!=4);
    }
}
