/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

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

    public static void main(String[] args) {
        // Example usage:
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");

        Path pathAB = new Path(nodeA, nodeB);
        System.out.println(pathAB); // Output: Path from A to B
    }
    
}
