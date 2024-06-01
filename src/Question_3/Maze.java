/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

/**
 *
 * @author xhu
 */
public class Maze {
    private char[][] grid; 
    private int numRows;   
    private int numCols;  

    private static Map<String, Node> node = new HashMap<>();
    public Maze() {
        this.numRows = 6;
        this.numCols = 7;
        this.grid = new char[numRows][numCols];
        initializeMaze(); 
    }
    private void initializeMaze() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col] = 'X';
            }
        }
    }
    public void setOpenPath(int row, int col) {
            grid[row][col] = ' ';
    }
    public void printMaze() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }


    public static void addRoute(String[] data) {
        for (int i = 1; i < data.length; i++) {
            String[] parts = data[i].split(",");
            String name = parts[0];
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
    
            Node vertex = new Node(name, x, y);
            node.put(name, vertex);
        }
        // Link the vertices
        for (int i = 1; i < data.length; i++) {
            String[] parts = data[i].split(",");
            String name = parts[0];
            // System.out.println(parts[0]+"<<<parts[0]");
    
            for (int j = 3; j < parts.length; j++) {
                String linkedVertexName = parts[j];
                if (!linkedVertexName.equals("A")) {
                    Node linkedVertex = node.get(linkedVertexName);
                    // System.out.println(linkedVertexName+"<<<linkedVertexName");
                    node.get(name).linkedVertices.add(linkedVertex);
                } 
            }
        }

    }

    private static List<Node> findRoute(Node start, Node exit) {
        Set<Node> visited = new HashSet<>();
        List<Node> path = new ArrayList<>();

        if (dfs(start, exit, visited, path)) {
            return path;
        } else {
            return null;
        }
    }

    private static boolean dfs(Node current, 
    Node exit, 
    Set<Node> visited, 
    List<Node> path) {
        visited.add(current);
        path.add(current);
        // System.out.println(current+"<<<current>>>");
        // System.out.println(exit+"<<<exit>>>");
        if (current.equals(exit)) {
            return true;
        }

        for (Node vertex : current.linkedVertices) {
            System.out.println(current.linkedVertices + "<<current.linkedVertices");
            if (!visited.contains(vertex) 
            && dfs(vertex, exit, visited, path)) {
                return true;
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
        return false;
    }

    public static String[] loadMazeFromFile(String filename) throws IOException {
        List<String> mazeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mazeList.add(line);
            }
        }
        return mazeList.toArray(new String[0]);
    }


    public static void main(String[] args) throws IOException {

        // loadMazeFromFile("maze.txt");
        // String[] data = {
        //     "22,7,6"
        //     ,"START,0,2,B,A"
        //     ,"B,1,2,C,K"
        //     ,"C,1,3,D,E"
        //     ,"D,1,4,A,A"
        //     ,"E,2,3,F,J"
        //     ,"F,2,4,G,H"
        //     ,"G,2,5,A,A"
        //     ,"H,3,4,A,I"
        //     ,"I,4,4,A,A"
        //     ,"J,2,2,A,A"
        //     ,"K,1,1,L,A"
        //     ,"L,2,1,N,M"
        //     ,"M,2,0,A,A"
        //     ,"N,3,1,O,A"
        //     ,"O,3,2,A,P"
        //     ,"P,4,2,Q,V"
        //     ,"Q,4,3,R,S"
        //     ,"R,3,3,A,A"
        //     ,"S,5,3,T,U"
        //     ,"T,5,4,A,A"
        //     ,"U,5,2,W,A"
        //     ,"V,4,1,A,A"
        //     ,"EXIT,6,2,A,A"
        // };
        // String[] data = {
        //     "24,7,6"
        //     ,"START,0,2,B,A"
        //     ,"B,1,2,C,K"
        //     ,"C,1,3,D,E"
        //     ,"D,1,4,A,A"
        //     ,"E,2,3,F,J"
        //     ,"F,2,4,G,H"
        //     ,"G,2,5,A,A"
        //     ,"H,3,4,A,I"
        //     ,"I,4,4,A,A"
        //     ,"J,2,2,A,A"
        //     ,"K,1,1,L,A"
        //     ,"L,2,1,N,M"
        //     ,"M,2,0,A,A"
        //     ,"N,3,1,O,A"
        //     ,"O,3,2,A,P"
        //     ,"P,4,2,Q,V"
        //     ,"Q,4,3,R,S"
        //     ,"R,3,3,A,O"
        //     ,"S,5,3,T,U"
        //     ,"T,5,4,A,A"
        //     ,"U,5,2,W,A"
        //     ,"V,4,1,N,A"
        //     ,"EXIT,6,2,A,A"
        // };
        // String[] data = loadMazeFromFile("src/Question_3/Maze1.txt");
        String[] data = loadMazeFromFile("src/Question_3/Maze2.txt");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace(",W,", ",EXIT,");
        }
        addRoute(data);
        Node[][] verticesArray = new Node[7][6]; 
        for (Node vertex : node.values()) {
            verticesArray[vertex.x][vertex.y] = vertex;
        }
        List<Node> path = findRoute(node.get("START"), node.get("EXIT"));
        // Maze maze = new Maze();
        // if (path != null) {
        //     for (Node vertex : path) {
        //         maze.setOpenPath(vertex.y, vertex.x);
        //     }
        // } 
        // maze.printMaze(); 

        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel(frame, verticesArray, path);
        frame.add(panel);
        frame.setSize(800, 700);
        frame.setVisible(true);


        

    
      


    }
        
}
