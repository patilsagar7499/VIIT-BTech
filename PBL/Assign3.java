import java.util.Scanner;
class Student{
    int[] a=new int[100];
    int[] b=new int[100];
    public int n;
    Scanner sc=new Scanner(System.in);
    void insert()
    {
       System.out.println("Enter the no. of students:");
       n=sc.nextInt();
       System.out.println("Enter the Students Roll no.& marks:");
       for(int i=0;i<n;i++)
       {
          a[i]=sc.nextInt();
          b[i]=sc.nextInt();
       }
    }
    void delete()
    {
        int z;
        System.out.println("Enter the Roll no. of student that you want to delete:");
        z=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(a[i]==z)
            {
                int temp=a[i+1];
                a[i+1]=a[i];
                a[i]=temp;
                n--;
            }
        }
    }
    void update()
    {
        int x;
        System.out.println("Enter the Roll no. of student that you want to update:");
        x=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(a[i]==x)
            {
                System.out.println("Enter new marks:");
                b[i]=sc.nextInt();
            }
        }

    }
    void search()
    {
        int y;
        System.out.println("Enter the Students Roll no. that you want to be :");
        y=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(a[i]==y)
            { int j=i+1;
                System.out.println("Student:"+j);
                System.out.println("Roll no.:"+a[i]);
                System.out.println("Marks:"+b[i]);
            }
        }
    }
    void display()
    {
        for(int i=0;i<n;i++)
        {
            int j=i+1;
            System.out.println("Student:"+j);
            System.out.println("Roll no.:"+a[i]);
            System.out.println("Marks:"+b[i]);
        }
    }
}



public class Assign3{
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       Student s=new Student();
       int choice;
       do{
       System.out.println("Enter the choice:1)Insert,2)Delete,3)Update,4)Search,5)Display,6)Exit");
       choice=sc.nextInt();
       switch(choice)
       {
           case 1:
           s.insert();
           break;
           case 2:
           s.delete();
           break;
           case 3:
           s.update();
           break;
           case 4:
           s.search();
           break;
           case 5:
           s.display();
           break;
       }
        }while(choice!=6);
    }
}