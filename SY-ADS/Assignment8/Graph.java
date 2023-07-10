
import java.util.*;

public class Graph{

    private Map<Integer, Node> vertices = new HashMap<Integer, Node>(); // Map<ids, Nodes>

    private class Node{
        private int id;
        private int color; 
        private ArrayList<Integer> neighbors;

        Node(int id, int color, ArrayList<Integer> neighbors){
            if(color != -1 && color < 0){
                throw new IllegalArgumentException();
            }
            this.id = id;
            this.color = color;
            this.neighbors = neighbors;
        }

        Node(int id){
            this(id, -1, new ArrayList<Integer>());
        }

        private void setColor(int color){
            this.color = color;
        }
    }


    public void addVertex(int id, Node vertex){
        vertices.putIfAbsent(id, vertex);
    }

    public void addById(int id){
        Node v = new Node(id);
        vertices.putIfAbsent(id, v);

    }

    public void addAllByID(int[] ids){
        for(int id: ids){
            this.addById(id);
        }
    }

    public Node getVertex(int id){
        return vertices.get(id);
    }

    public void removeVertex(int id){
        vertices.remove(id);
    }

    public void addEdge(int source, int destination){
        List<Integer> v1 = vertices.get(source).neighbors;
        List<Integer> v2 = vertices.get(destination).neighbors;
        
        if(!v1.contains(destination)){
            v1.add(destination);
        }
       
        if(!v2.contains(source)){
            v2.add(source);
        }
    }

    public void removeEdge(int source, int destination){
        vertices.get(source).neighbors.remove(destination);
        vertices.get(destination).neighbors.remove(source);
    }

    public int getColor(int id){
        return vertices.get(id).color;
    }

    public void setColor(int id, int color){
        vertices.get(id).setColor(color);
    }

    public List<Integer> getNeighbors(int id){
        return vertices.get(id).neighbors;
    }

    public void printVertices(){
        Collection<Node> allV = vertices.values();
        for(Node v: allV){
            System.out.println(v.id + " --> " + v.neighbors.toString());
        }
    }

    /*
    public static void main(String[] args){ // test code
        Graph g = new Graph();

        for(int i = 0; i < 6; i++){
            g.addById(i);
        }

        g.addEdge(0, 1);
        g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,0);
        g.addEdge(5,4);
        g.addEdge(5,2);

        g.printVertices();
    }
    */

}
