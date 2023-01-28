import java.net.SocketPermission;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncProvider;
class Employee
{
    class Node{
             String Name;
             int id;
             double salary;
             Node next;
             Node(String n,int i,double s)
             {
                  this.Name=n;
                  this.id=i;
                  this.salary=s;
                  this.next=null;
             }
         }
         Node head=null;
         Node tail=null;
    public void insert(String n,int i,double s)
    {
        Node temp=new Node(n,i,s);  
        if (head==null)
        {
            head=temp;
            tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
    }
     public void delete(int i)
     {
         Node temp=this.head.next;
         Node ptemp=this.head;
         boolean found=false;
         if (this.head.id==i)
         {
              head=head.next;
              found=true;
         }
         else{
             while(temp!=null)
             {
                  if (temp.id==i)
                  {
                      ptemp.next=temp.next;
                      found=true;
                      System.out.println("Employee data deleted successfully!");
                      break;
                  }
             }
         }
         if(!found)
         {
            System.out.println("Employee Id not found.");
         }
     }
     public void search(int i)
     {
         Node temp=head;
         while(temp!=null)
         {
             if (temp.id==i)
             {
                 System.out.println("Employee Name:"+temp.Name);
                 System.out.println("Employee id:"+temp.id);
                 System.out.println("Employee salary:"+temp.salary);   
             }
             temp=temp.next;
         }
     }
     public void modify(int i,String n,double s)
     {
      Node temp=head;
      boolean found=false;
      while(temp!=null)
      {
          if (temp.id==i)
          {
              temp.Name=n;
              temp.salary=s;
              break;
          }
          temp=temp.next;
      } 
      if(!found)
      {
          System.out.println("Employee id not found.");
      }
     }
     public void display()
     {
         Node temp=this.head;
         while(temp!=null)
         {
             System.out.println("Employee Name:"+temp.Name);
             System.out.println("Employee id:"+temp.id);
             System.out.println("Employee Salary:"+temp.salary);
             System.out.println();
             temp=temp.next;
         }
     }
}




public class practical2 {
            public static void main(String[] args)
            {
               Employee e=new Employee();
               int choice;
               do{
               Scanner sc=new Scanner(System.in);
               System.out.println("Enter your choice:1)Insert,2)Delete,3)Search,4)Modify,5)Display,6)Exit");
               choice=sc.nextInt();
               switch(choice)
               {
                  case 1:
                  Scanner sc1=new Scanner(System.in);
                  System.out.println("Enter Employee Name:");
                  String name=sc1.nextLine();
                  Scanner sc2=new Scanner(System.in);
                  System.out.println("Enter Id No.:");
                  int id=sc2.nextInt();
                  System.out.println("Enter Salary:");
                  double salary=sc.nextDouble();
                  e.insert(name,id,salary);
                  break;
                  case 2:
                  System.out.println("Enter Id which want to be delete:");
                  id=sc.nextInt();
                  e.delete(id);
                  break;
                  case 3:
                  System.out.println("Enter searching Id:");
                  id=sc.nextInt();
                  e.search(id);
                  break;
                  case 4:
                  System.out.print("Enter Employee ID to search: ");
                int id3 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter new employee details:");
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Salary: ");
                double s = sc.nextDouble();
                e.modify(id3, n, s);
                    break;
                  case 5:
                  e.display();
                  break;
               }
               }while(choice!=6);
            }         
}
