
import java.util.*;

public class SudokuGraph {

    private final int NUM_col = 9;
    private final int NUM_row = 9;
    
    private int totalNodes = NUM_row * NUM_col;
    private Graph graph = new Graph();

    SudokuGraph(){
        this.generateGraph();
        this.connectEdges();
    }

    private void generateGraph(){
        for (int i = 1; i < 82; i++){
            graph.addById(i);
        }
    }

    public int[][] getGridMatrix(){
        int[][] matrix = new int[9][9];
        int count = 1;

        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                matrix[i][j] = count;
                count++;
            }
        }

        return matrix;
    }

    private List<Integer> getConnections(int row, int col){
        int[][] matrix = this.getGridMatrix();
        ArrayList<Integer> connections = new ArrayList<Integer>();

        // connect row
        for(int i = col + 1; i < 9; i++){
            connections.add(matrix[row][i]);
        }

        // connect columns
        for(int i = row + 1; i < 9; i++){
            connections.add(matrix[i][col]);
        }

        // connect all in the 3x3 block, not same row and col
        if (row % 3 == 0){
            if(col % 3 == 0){
                connections.add(matrix[row+1][col+1]);
                connections.add(matrix[row+1][col+2]);
                connections.add(matrix[row+2][col+1]);
                connections.add(matrix[row+2][col+2]);
            }

            else if(col % 3 == 1){
                connections.add(matrix[row+1][col-1]);
                connections.add(matrix[row+1][col+1]);
                connections.add(matrix[row+2][col-1]);
                connections.add(matrix[row+2][col+1]);
            }

            else if (col % 3 == 2){
                connections.add(matrix[row+1][col-2]);
                connections.add(matrix[row+1][col-1]);
                connections.add(matrix[row+2][col-2]);
                connections.add(matrix[row+2][col-1]);

            }
        }
        else if(row % 3 == 1){
            if (col % 3 == 0){
                connections.add(matrix[row-1][col+1]);
                connections.add(matrix[row-1][col+2]);
                connections.add(matrix[row+1][col+1]);
                connections.add(matrix[row+1][col+2]);
            }

            else if (col % 3 == 1){
                connections.add(matrix[row-1][col-1]);
                connections.add(matrix[row-1][col+1]);
                connections.add(matrix[row+1][col-1]);
                connections.add(matrix[row+1][col+1]);
            }
            else if (col % 3 == 2){
                connections.add(matrix[row-1][col-2]);
                connections.add(matrix[row-1][col-1]);
                connections.add(matrix[row+1][col-2]);
                connections.add(matrix[row+1][col-1]);
            }
        }
        else if (row % 3 == 2){
            if (col % 3 == 0){
                connections.add(matrix[row-2][col+1]);
                connections.add(matrix[row-2][col+2]);
                connections.add(matrix[row-1][col+1]);
                connections.add(matrix[row-1][col+2]);
            }
            else if (col % 3 == 1){
                connections.add(matrix[row-2][col-1]);
                connections.add(matrix[row-2][col+1]);
                connections.add(matrix[row-1][col-1]);
                connections.add(matrix[row-1][col+1]);
            }
            else if (col % 3 == 2){
                connections.add(matrix[row-2][col-2]);
                connections.add(matrix[row-2][col-1]);
                connections.add(matrix[row-1][col-2]);
                connections.add(matrix[row-1][col-1]);
            }
        }

        return connections;
    }

    private void connectNodes(HashMap<Integer, List<Integer>> headConnections){
        for (Integer head: headConnections.keySet()){
            List<Integer> connections = headConnections.get(head);
            for(Integer v: connections){
                this.graph.addEdge(head, v);
            }
        }
    }

    private void connectEdges(){
        int[][] matrix = this.getGridMatrix();

        HashMap<Integer, List<Integer>> headConnections = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                int head = matrix[i][j];
                List<Integer> connections = this.getConnections(i, j);
                headConnections.put(head, connections);
            }
        }

        this.connectNodes(headConnections);
    }

    public int getColor(int id){
        return graph.getColor(id);
    }

    public void setColor(int id, int color){
        graph.setColor(id, color);
    }

    public List<Integer> getNeighbors(int id){
        return graph.getNeighbors(id);
    }

    public int getTotalNodes(){
        return this.totalNodes;
    }

    // public static void main(String[] args){
    //     SudokuGraph sg = new SudokuGraph();
    //     sg.graph.printVertices();

    // }
    
}
