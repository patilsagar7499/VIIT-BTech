import java.util.Scanner;
public class practical8 {
    public void palindrom(String str )
    { 
       String reverseStr=""; 
       int strlength=str.length();
       for(int i=(strlength-1);i>=0;--i){
           reverseStr=reverseStr+str.charAt(i);
       }
       if(str.toLowerCase().equals(reverseStr.toLowerCase())){
           System.out.println(str+" is a Palindrome String.");
       }
       else{
           System.out.println(str+" is not a Palindrome String.");
       }
    }
    public static void concatinate(String s1,String s2)
    {
        System.out.println("Concatination:"+s1+s2);
    }
    public static void substring(char str[],int n)
    {
        System.out.println("Substrings:");
        for(int len=1;len<=n;len++){
          for(int i=0;i<=n-len;i++){
              int j=i+len-1;
              for(int k=i;k<=j;k++)
              {
                  System.out.print(str[k]);
              }
              System.out.println();
          }
        }
    }
    public static void main(String[] args)
    {
        practical8 p=new practical8();
        String s="Radar";
        p.palindrom(s);
        String q="Area";
        p.concatinate(s,q);
        char str[]={'a','b','c'};
        p.substring(str,str.length);
    }
}
