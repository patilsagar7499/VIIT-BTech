
import java.util.Scanner;

public class Assignment3
{
  int minKey(int keys[], boolean mst[], int n) {
    int min  = Integer.MAX_VALUE, minIndex = -1;
    for(int i=0; i<n; i++)
      if(mst[i] == false && keys[i] < min) {
        minIndex = i;
        min = keys[i];
      }
    return minIndex;
  }
  
  void sumW(int parent[], int weight[][], int n) {
      int sum = 0;
      for(int i=1; i<n; i++)
        sum+=weight[i][parent[i]];
      System.out.println("Weight of Minimum Spanning Tree: "+sum);
  }
  
  void printMST(int parent[], int graph[][], int n)
  {
      System.out.println("Edge \tWeight");
      for (int i = 1; i < n; i++)
          System.out.println(parent[i] + " - " + i + "\t"+ graph[i][parent[i]]);
  }

  void primsAlgo(int n, int[][] weight) {
    int keys[] = new int[n];
    boolean mst[] = new boolean[n];
    int parent[] = new int[n];

    for(int i=0; i<n; i++) {
      keys[i] = Integer.MAX_VALUE;
      parent[i] = -1;
      mst[i] = false;
    }

    keys[0] = 0;
    parent[0] = -1;
    for(int i=0; i<n-1; i++) {
      int u = minKey(keys, mst, n);
      mst[u] = true;
      for(int j=0; j<n; j++) {
        if(weight[i][j] != 0 && mst[j] == false && weight[i][j] < keys[j]) {
          parent[j] = i;
          keys[j] = weight[i][j];
        }
      }
    }
    sumW(parent, weight, n);
    printMST(parent, weight, n);
  }

  public static void main(String args[]) {
    Assignment3 t = new Assignment3();
	Scanner sc = new Scanner(System.in);	
    System.out.println("Enter the number of edges in the graph: ");
    int n = sc.nextInt();
    int weight[][] = new int[n][n];

    for(int i=0; i<n; i++)
      for(int j=0; j<n; j++)
      {
          System.out.println("Enter the weight of Edge["+i+"]["+j+"]: ");
          weight[i][j] = sc.nextInt();
      }
    t.primsAlgo(n, weight);

  }
}