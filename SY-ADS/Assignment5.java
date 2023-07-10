
import java.util.Scanner;

public class Assignment5 {
	
	int marks[] = new int[20];
	Scanner scanner = new Scanner(System.in);
	
	public Assignment5() {
		for(int i = 0; i < 20; i++) {
			marks[i] = 0;
		}
	}
	
	// Code to create MinHeap
	public void insertHeap(int tot) {
		for(int i = 0; i < tot; i++) {
			System.out.print("Enter Marks: ");
			marks[i] = scanner.nextInt();
			
			int j = i;
			int par = j/2;
			
			while(marks[j]<=marks[par] && j!=0) {
				int temp = marks[j];
				marks[j] = marks[par];
				marks[par] = temp;
				j = par;
				par = j/2;
			}
		}
	}
	
	// Finding MaximuM Marks 
	public void maxHeap(int tol) {
		int max = marks[0];
		for(int i = 1; i < tol; i++) {
			if(max < marks[i]) {
				max = marks[i];
			}
		}
		System.out.println("Maximum Marks Obtained By Student is: "+ max);
	}
	
	// Finding Minimum Marks
	public void minHeap() {
		System.out.println("Mimimum Marks Obtained By Student is: "+ marks[0]);
	}
	 

	public static void main(String[] args) {
		Assignment5 ob = new Assignment5();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Numbers Of Student: ");
		int total = scanner.nextInt();
		ob.insertHeap(total);
		
		ob.minHeap();
		ob.maxHeap(total);
		
	}
}