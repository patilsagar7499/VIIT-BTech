import javax.lang.model.util.ElementScanner14;

public class Assign7 {
    public static void main(String[] args)
    {
         int[] a=new int[8];
         a[0]=2;
         a[1]=4;
         a[2]=3;
         a[3]=6;
         a[4]=4;
         a[5]=8;
         a[6]=5;
         a[7]=10;
         int size=8;
         for(int i=1;i<size;i++)
         {
             for(int j=0;j<size-i;j++)
             {
                 if(a[j]>a[j+1])
                 {
                     int temp=a[j];
                     a[j]=a[j+1];
                     a[j+1]=temp;
                 }
             }
         }
         System.out.println("Sorted Array:");
         for(int i=0;i<size;i++)
         {
             System.out.println(a[i]);
         }
         int value=3;
         int index=-1;
         int start=0;
         int end=size;
         int mid=(start+end)/2;

         while(start<=end)
         {
             if(a[mid]==value)
             {
                 index=mid;
                 break;
             }
             else if(a[mid]>value)
             {
                 end=mid-1;
                 
             }
            else 
            {start=mid+1;
            }
            mid=(start+end)/2;
         }
         System.out.println();
         System.out.println(index);
         
    }
}
