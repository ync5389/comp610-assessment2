/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel{
    Maze maze = new Maze(10, 10);
    JFrame frame;
    
    public Panel() {
        // Initialize the maze and frame here
        maze = new Maze(10, 10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Implement your custom painting logic here
        // For example, draw the maze grid, paths, walls, etc.
        // You can use methods like g.drawRect(), g.fillRect(), g.drawLine(), etc.
        // Remember to call repaint() to update the panel when needed
    }

    
}
