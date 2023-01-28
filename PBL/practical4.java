import java.util.Stack;
public class practical4{
    public static String reverse(String str)
    {
        if (str==null||str.equals("")){
            return str;
        }
        Stack<Character> stack=new Stack<Character>();
        char[] ch=str.toCharArray();
        for(int i=0;i<str.length();i++){
            stack.push(ch[i]);
        }
        int k=0;
        while(!stack.isEmpty())
        {
            ch[k]=stack.pop();
            k++;
        }
        return String.copyValueOf(ch);
    }
    public static void main(String[] args)
    {
        String str="INDIA";
        System.out.println("Before reversing the String:"+str);
        str=reverse(str);
        System.out.println("The reversed string is:"+str);
    }
}