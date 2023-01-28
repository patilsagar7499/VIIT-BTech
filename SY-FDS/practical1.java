import java.net.SocketPermission;
import java.util.Scanner;
class Student
{
   public int a[]=new int[100];
   public int b[]=new int[100];
   public int n;
   public void insert()
   { 
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the no. of students:");
      n=sc.nextInt();
      for(int i=0;i<n;i++){
      System.out.println("Enter student Roll NO. and marks:");
      a[i]=sc.nextInt();
      b[i]=sc.nextInt();
      }
   }
   public void delete()
   {
       int x;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the roll no. of student that wanted to be removed");
       x=sc.nextInt();
       for(int i=0;i<n;i++)
       {
         if(a[i]==x)
         { int j;
             for(j=i;j<n-1;j++)
             {
                 a[j]=a[j+1];
                 b[j]=b[j+1];
                 n=n-1;
             }
            
         }
       }
   }
   public void search()
   {
       int y;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the roll no. of student:");
       y=sc.nextInt();
       for(int i=0;i<n;i++)
       {
           if (a[i]==y)
           {
               System.out.println("Marks:"+b[i]);
           }
       }
   }
   public void display()
   {
       for(int i=0;i<n;i++)
       {
           System.out.println("Roll No:"+a[i]+" "+"Marks:"+b[i]);
       }
   }
}
public class practical1
{
    public static void main(String[] args)
    {
        int choice;
        Student s=new Student();
        do{
        System.out.println("Enter the choice:1)Insert,2)Delete,3)Display,4)Search,5)Exit");
        Scanner sc=new Scanner(System.in);
        choice =sc.nextInt();
        switch(choice)
        {
            case 1:
            s.insert();
            break;
            case 2:
            s.delete();
            break;
            case 3:
            s.display();
            break;
            case 4:
            s.search();
            break;
        }
    }while(choice!=5);
    }
}