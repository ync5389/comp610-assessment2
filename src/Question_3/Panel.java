/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel{
      
    Maze maze = new Maze();
    
    public Panel()
    {

    }
    
    public void paint(Graphics g)
    {
        this.paintComponent(g);
        
        repaint();
    }
    
}
