
import java.util.Scanner;
 public class Assignment1{
	static class Node{
		int value;
		Node left,right;
		Node(int value)
		{
			this.value=value;
			left=null;
			right=null;
		}
	}
	public static void insert(Node node,int value)
	{
		if(value<node.value)
		{
			if(node.left!=null)
			{
				insert(node.left,value);
			}
			else
			{
				System.out.println("Inserted "+value+" to the left of "+node.value);
				node.left=new Node(value);
			}
		}
		else if(value>node.value)
		{
			if(node.right!=null)
			{
				insert(node.right,value);
			}
			else {
			System.out.println("Inserted "+value+" to the right of "+node.value);
			node.right=new Node(value);
			}
		}
	}
	   public Node minNode(Node root) {  
          if (root.left != null)  
              return minNode(root.left);  
          else  
              return root;  
      }  
  
      //deleteNode() will delete the given node from the binary search tree  
      public Node deleteNode(Node node, int value) {  
          if(node == null){  
              return null;  
           }  
          else {  
              //value is less than node's data then, search the value in left subtree  
              if(value < node.value)  
                  node.left = deleteNode(node.left, value);  
  
              //value is greater than node's data then, search the value in right subtree  
              else if(value > node.value)  
                  node.right = deleteNode(node.right, value);  
  
              //If value is equal to node's data that is, we have found the node to be deleted  
              else {  
                  //If node to be deleted has no child then, set the node to null  
                  if(node.left == null && node.right == null)  
                      node = null;  
  
                  //If node to be deleted has only one right child  
                  else if(node.left == null) {  
                      node = node.right;  
                  }  
  
                  //If node to be deleted has only one left child  
                  else if(node.right == null) {  
                      node = node.left;  
                  }  
  
                  //If node to be deleted has two children node  
                  else {  
                      //then find the minimum node from right subtree  
                      Node temp = minNode(node.right);  
                      //Exchange the data between node and temp  
                      node.value= temp.value;  
                      //Delete the node duplicate node from right subtree  
                      node.right = deleteNode(node.right, temp.value);  
                  }  
              }  
              return node;  
          }  
      }  
	public void traversePreOrder(Node node)
	{
		if(node!=null)
		{
			System.out.println(" "+node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	public void traverseInOrder(Node node)
	{
		if(node!=null)
		{
			traverseInOrder(node.left);
			System.out.println(" "+node.value);
			traverseInOrder(node.right);
		}
	}
	public void traversePostOrder(Node node)
	{
		if(node!=null)
		{
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.println(" "+node.value);
		}
	}

     public static void main(String args[])
     {
    	 Assignment1 tree =new Assignment1();
    	 int x,y,z;
    	 System.out.println("Enter Root Node:");
    	 Scanner sc=new Scanner(System.in);
    	 x=sc.nextInt();
    	 Node root =new Node(x);
    	 System.out.println("Enter no. of nodes to insert:");
    	 y=sc.nextInt();
    	 for(int i=0;i<y;i++)
    	 {
    	     System.out.println("Enter value of node:");
    	     z=sc.nextInt();
    	     tree.insert(root,z); 
    	 }
         
         System.out.println("Traversing tree pre order:");
         tree.traversePreOrder(root);
         System.out.println("Traversing tree in order:");
         tree.traverseInOrder(root);
         System.out.println("Traversing tree post order:");
         tree.traversePostOrder(root);
         int u;
         System.out.println("Enter the node you want to delete:");
         u=sc.nextInt();
         tree.deleteNode(root,u);
         System.out.println("Traversing tree pre order:");
         tree.traversePreOrder(root);
         System.out.println("Traversing tree in order:");
         tree.traverseInOrder(root);
         System.out.println("Traversing tree post order:");
         tree.traversePostOrder(root);
     }
}

