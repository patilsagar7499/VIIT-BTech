
import java.util.*;

public class SudokuBoard {
    // Class containing the sudoku board and the graph coloring algorithm
    
    SudokuGraph graph = new SudokuGraph();
    int[][] matrix = graph.getGridMatrix();
    int[][] board = this.getBoard();

  
    private int[][] getBoard(){ // example board, input others using setBoard()

        int[][] board = {
            {0,0,0,4,0,0,0,0,0},
            {4,0,9,0,0,6,8,7,0},
            {0,0,0,9,0,0,1,0,0},
            {5,0,4,0,2,0,0,0,9},
            {0,7,0,8,0,4,0,6,0},
            {6,0,0,0,3,0,5,0,2},
            {0,0,1,0,0,7,0,0,0},
            {0,4,3,2,0,0,6,0,5},
            {0,0,0,0,0,5,0,0,0}
        };

        return board;
    }

    public void setBoard(int[][] board){
        if(board.length != 9){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < board.length; i++){
            if (board[i].length != 9){
                throw new IllegalArgumentException();
            }
        }

        this.board = board;
    }

    private List<Integer> initColor(){
        List<Integer> given = new ArrayList<Integer>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != 0){
                    int id = matrix[i][j];
                    graph.setColor(id, board[i][j]);
                    given.add(id);
                }
            }
        }

        return given;
    }

    private boolean isValid(int id, int color, List<Integer> given){ 
        if(given.contains(id) && graph.getColor(id) == color){
            return true;
        }
        else if (given.contains(id)){
            return false;
        }

        List<Integer> neighbors = graph.getNeighbors(id);
        for(Integer v: neighbors){
            if(graph.getColor(v) == color){
                return false;
            }
        }
        return true;
    }

    public void solveGraphColoring(){
        List<Integer> given = this.initColor();

        if(!this.solveColoring(1, 9, given)){
            System.out.println("Cannot solve this sudoku");
        }
        int count = 1;
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                board[i][j] = graph.getColor(count);
                count++;
            }
        }
    }

    private boolean solveColoring(int id, int numC, List<Integer> given){ // coloring algorithm 
        if(id == graph.getTotalNodes() + 1){
            return true;
        }
        for (int c = 1; c < numC + 1; c++){
            if(this.isValid(id, c, given)){
                graph.setColor(id, c);
                if(this.solveColoring(id + 1, numC, given)){
                    return true;
                }
            }
            if(!given.contains(id)){
                graph.setColor(id, -1);
            }
        }

        return false;
    }

    public void printBoard(){
        System.out.println("  1 2 3   4 5 6   7 8 9");
        for (int i = 0; i < board.length; i++){
            if (i % 3 == 0){
                System.out.println("  - - - - - - - - - - - ");
            }
            
            for (int j = 0; j < board[i].length; j++){
                if (j % 3 == 0){
                    System.out.print("| ");
                }
                if (j == 8){
                    System.out.println(board[i][j] + " | " + (i+1));
                }
                else{
                    System.out.print(board[i][j] + " ");
                }
            }
        }
        System.out.println("  - - - - - - - - - - - ");
    }


    public static void main(String[] args){
        SudokuBoard b = new SudokuBoard();
        /*        
      int[][] board = {
            {0,0,0,2,6,0,7,0,1},
            {6,8,0,0,7,0,0,9,0},
            {1,9,0,0,0,4,5,0,0},
            {8,2,0,1,0,0,0,4,0},
            {0,0,4,6,0,2,9,0,0},
            {0,5,0,0,0,3,0,2,8},
            {0,0,9,3,0,0,0,7,4},
            {0,4,0,0,5,0,0,3,6},
            {7,0,3,0,1,8,0,0,0}
        };
        */
      
        int[][] board1 = {
            {2,0,0,3,0,0,0,0,0},
            {8,0,4,0,6,2,0,0,3},
            {0,1,3,8,0,0,2,0,0},
            {0,0,0,0,2,0,3,9,0},
            {5,0,7,0,0,0,6,2,1},
            {0,3,2,0,0,6,0,0,0},
            {0,2,0,0,0,9,1,4,0},
            {6,0,1,2,5,0,8,0,9},
            {0,0,0,0,0,1,0,0,2}
        };
        
        b.setBoard(board1);
        
        System.out.println("Before Solving:");
        System.out.println();
        b.printBoard();
        System.out.println();

        
        b.solveGraphColoring();
        System.out.println("After Solving:");
        System.out.println();
        b.printBoard();
    }



}
