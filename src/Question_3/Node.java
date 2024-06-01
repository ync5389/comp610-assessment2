/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author xhu
 */
public class Node {
    String name;
    int x, y;
    List<Node> linkedVertices;

    public Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.linkedVertices = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }
}
