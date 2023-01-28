import java.util.Scanner;
class CirqularQueue
{
    class Node{
        int data;
        Node next;
        Node(int d)
        {
            this.data=d;
        }
    }
    Node front;
    Node rear;
    int max,count;
    CirqularQueue(int m)
    {
        this.max=m;
        this.count=0;
        this.front=null;
        this.rear=null;
    }
    void add(int d)
    {
        if (this.count!=this.max)
        {
            Node temp=new Node(d);
            if(this.front==null)
            {
                   front =temp;
            }
            else{
                this.rear.next=temp;}

                rear=temp;
                this.rear.next=front;
                this.count++;
            
        }
        else{
            System.out.println("Max order limit exceded");
        }
    }
    void delete(){
      if(this.front==null)
      {
          System.out.println("Queue is empty!");
      }
      else{
          if(this.front==this.rear)
          {
              this.front=null;
              this.rear=null;
              System.out.println("Order executed Successfully ");
          }
          else{
              this.front=this.front.next;
              this.rear.next=this.front;
              this.count--;
              System.out.println("Order executed Successfully ");
          }
      }

    }
    void display()
    {
        Node temp=this.front;
        while(temp.next!=this.front)
        {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(temp.data+" ");
        System.out.println();
    }
}
public class Assign6 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of maximum orders: ");
		int m = sc.nextInt();
		sc.nextLine();
		CirqularQueue c1 = new CirqularQueue(m);
		boolean cont = true;
		while(cont) {
			int choice;
			System.out.println("1.Place Order: ");
			System.out.println("2.Execute next Order: ");
			System.out.println("3.Display Order: ");
			System.out.println("4.Exit: ");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.print("Enter Quantity: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				c1.add(quantity);
				break;
			case 2:
            c1.delete();
            break;
			case 3:
				c1.display();
				break;
			case 4:
				cont = false;
				break;
			default:
				System.out.println("Enter valid choice!");
			}
    }
}}
