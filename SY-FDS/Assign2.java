// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class sparse{
void sparse_matrix(int r,int c,int [][]a)
{
   int k=1;
   int[][]sparse=new int[10][3];
   for(int i=0;i<r;i++)
   {
       for(int j=0;j<c;j++)
       {
           if(a[i][j]!=0)
           {
               sparse[k][0]=i;
               sparse[k][1]=j;
               sparse[k][2]=a[i][j];
               k++;
           }
       }
   }
   sparse[0][0]=r;
   sparse[0][1]=c;
   sparse[0][2]=k-1;
   //display
   System.out.println("Rows Columns Values");
   for(int i=0;i<=sparse[0][2];i++)
   {
       System.out.println("\n");
       for(int j=0;j<3;j++)
       {
           System.out.println("\t"+sparse[i][j]);
       }
   }
   int[][]t=new int[100][3];
    k=1;
    for(int z=0;z<sparse[0][1];z++)
    {
        for(int i=1;i<=sparse[0][2];i++)
        {
            if(sparse[i][1]==z)
            {
               t[k][0]=sparse[i][1];
               t[k][1]=sparse[i][0];
               t[k][2]=sparse[i][2];
               k++;
            }
        }
    }
    t[0][0]=sparse[0][1];
    t[0][1]=sparse[0][0];
    t[0][2]=sparse[0][2];
    System.out.println("Rows Columns Values");
   for(int i=0;i<=sparse[0][2];i++)
   {
       System.out.println("\n");
       for(int j=0;j<3;j++)
       {
           System.out.println("\t"+t[i][j]);
       }
   }
   int col,loc;
   int[][] ft=new int[100][3];
   int[] total=new int[sparse[0][1]];
   int[] index=new int[sparse[0][1]+1];
   for(int i=0;i<sparse[0][1];i++)
   {
       total[i]=0;
   }
   for(int i=1;i<=sparse[0][2];i++)
   {
       col=sparse[i][1];
       total[col]++;
   }
   index[0]=1;
   for(int i=1;i<=sparse[0][1];i++)
   {
       index[i]=total[i-1]+index[i-1];
   }
   ft[0][0]=sparse[0][1];
   ft[0][1]=sparse[0][0];
   ft[0][2]=sparse[0][2];
   for(int i=1;i<=sparse[0][2];i++)
   {
       col=sparse[i][1];
       loc=index[col];
       ft[loc][0]=sparse[i][1];
       ft[loc][1]=sparse[i][0];
       ft[loc][2]=sparse[i][2];
       index[col]++;              //Imp
   }
   //ft display
   System.out.println("Fast Transpose:");
   for(int i=0;i<=sparse[0][2];i++)
   {
    System.out.println("\n");
       for(int j=0;j<3;j++)
       {
           System.out.println("\t"+ft[i][j]);
       }
   }
}

}
class Assign2 {
    public static void main(String[] args) {
        int r,c;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows and columns:");
         r=sc.nextInt();
         c=sc.nextInt();
        int[][] a=new int[10][10];
        System.out.println("Enter matrix elements:");
        for(int i=0;i<r;i++)
        {
          for(int j=0;j<c;j++)
          {
              a[i][j]=sc.nextInt();
          }
        }
        sparse s=new sparse();
        s.sparse_matrix(r,c,a);
    }
}