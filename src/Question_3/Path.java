/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author xhu
 */
public class Path {
    private Node start;
    private Node end;
    public Path(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
    List<Node> path = findPath(start, end);

    private static List<Node> findPath(Node start, Node exit) {
        Set<Node> visited = new HashSet<>();
        List<Node> path = new ArrayList<>();

        if (dfs(start, exit, visited, path)) {
            return path;
        } else {
            return null;
        }
    }

    private static boolean dfs(Node current, Node exit, Set<Node> visited, List<Node> path) {
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

    
    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Path from " + start + " to " + end;
    }

    // public static void main(String[] args) {
    //     // Example usage:
       
    // }
    
}
