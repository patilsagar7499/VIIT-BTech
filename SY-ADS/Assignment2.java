
public class Assignment2
{
 static class Node
 {
  int data;
  Node left,right;
  boolean RThread,LThread;
  Node(int data)
  {
   this.data=data;
      left=right=null;
      RThread=LThread=true;
  }
 } 
 public Node root;
 static Node Insert(Node root,int key)
 {
  Node ptr = root;
  Node par = null;
  while(ptr != null)
  {
   if(key == ptr.data)
   {
    System.out.println("duplicate key");
    return root;
   }
   par = ptr;
   if(key<ptr.data)
   {
    if(ptr.LThread == false)
     ptr = ptr.left;
    else
     break;
   }
   else
   {
    if(ptr.RThread == false)
     ptr = ptr.right;
    else
     break;
   }
   return root;
  }
  Node temp = new Node(key);
  if(par == null)
  {
   root = temp;
   temp.left = temp.right = null;
  }
  else if(key<par.data)
  {
   temp.left = par.left;
   temp.right = par;
   par.LThread = false;
   par.left = temp;
  }
  else
  {
   temp.right = par.right;
   temp.left = par;
   par.RThread = false;
   par.right = temp;
  }
  return root;
 }
 static Node InorderSuccessor(Node ptr)
 {
  if(ptr.RThread == true)
   return ptr.right;
  ptr = ptr.right;
  while(ptr.LThread == false)
   ptr = ptr.left;
  return ptr;
 }
 static void Inorder(Node root)
 {
  if(root == null)
   System.out.println("Tree is empty.");
  Node ptr = root;
  while(ptr.LThread == false)
   ptr = ptr.left;
  while(ptr != null)
  {
   System.out.print(ptr.data+" ");
   ptr = InorderSuccessor(ptr);
  }
 }
 public static void main(String[] args)
 {
     Node root = null;
     root = Insert(root,20);
     root = Insert(root,10);
     root = Insert(root,30);
     Inorder(root);
     
 }
}
