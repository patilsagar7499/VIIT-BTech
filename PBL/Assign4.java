
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.BlockElement;
class Employee{
class Node{
    String name;
    int id;
    double salary;
    Node next;
    Node(String n,int i,double s)
    {
        this.name=n;
        this.id=i;
        this.salary=s;
        this.next=null;
    }
}
    Node head=null;
    Node tail=null;
    void insert(String n,int i,double s)
    {
        Node temp=new Node(n, i, s);
        if(head==null)
        {
           head=temp;
           tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
    }
    void delete(int i)
    {
        Node temp=head.next;
        Node ptemp=head;
        boolean found=false;
        if(head.id==i)
        {
            head=head.next;
            found=true;
        }
        else{
            while(temp!=null)
            if(temp.id==i)
            {
                ptemp.next=temp.next;
                System.out.println("Successfully deleted!");
                found=true;
                break;
            }
        }
        if(!found)
        {
            System.out.println("Employee id not found!");
        }
    }
    void update(int i,String n,double s)
    {

    Node temp = head;
    boolean found = false;
    while(temp != null) {
    if(temp.id == i) {
    temp.name = n;
    temp.salary = s;
                break;
    }
    temp = temp.next;
    found=true;
    }
    if(!found)
    System.out.println("Employee ID not found!!");
    
    }
    void search(int i)
    {
        Node temp=head;
        while(temp!=null)
        {
            if(temp.id==i)
            {
            System.out.println("Name:"+temp.name);
            System.out.println("Id:"+temp.id);
            System.out.println("Salary:"+temp.salary);
            break;
            }
            temp=temp.next;
            
        }
    }
    void display()
    {
        Node temp=this.head;
        while(temp!=null)
        {
            System.out.println("Name:"+temp.name);
            System.out.println("Id:"+temp.id);
            System.out.println("Salary:"+temp.salary);
            System.out.println();
            temp=temp.next;
        }
    }
}
public class Assign4 {
    public static void main(String[] args) 
    {
    Employee e=new Employee();
    int choice;
    do{
    System.out.println("Enter the choice:1)Insert,2)Delete,3)Update,4)Search,5)Display,6)Exit");
    Scanner sc=new Scanner(System.in);
    choice=sc.nextInt();
    String name;
    int id;
    double salary;
    switch(choice)
    {
        case 1:
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter the Employee Name:");
        name=sc1.nextLine();
        Scanner sc2=new Scanner(System.in);
        System.out.println("Enter the Employee id:");
        id=sc2.nextInt();
        System.out.println("Enter the Employee salary:");
        salary=sc.nextDouble();
        e.insert(name,id,salary);
        break;
        case 2:
        System.out.println("Enter the id of employee that you want to delete:");
        id=sc.nextInt();
        e.delete(id);
        break;
        case 3:
         System.out.print("Enter Employee ID to update: ");
                int id3 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter new employee details:");
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Salary: ");
                double s = sc.nextDouble();
                e.update(id3, n, s);
                    break;
        case 4:
        System.out.print("Enter Employee ID to search: ");
        id=sc.nextInt();
        e.search(id);
        break;
        case 5:
        e.display();
        break;
    }
}while(choice!=6);
    }
}
