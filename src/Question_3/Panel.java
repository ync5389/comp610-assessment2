/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener {
    JFrame frame;
    int x= 100;
    int y= 100;
    int i= 0;

    Node[][] node;
    List<Route> routes = new ArrayList<>();
    List<Node> path;
    public Panel(JFrame frame, Node[][] node, List<Node> path){
        this.frame = frame;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.node = node;
        this.path = path;

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

            g.drawString("press 'UP-ARROW'", 650, 650);

            for(int i = 0; i < 7; i++){
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 5, 5);
                g.drawOval(x, y, 5, 5);
                for(int j = 0; j < 6; j++){
                    g.fillOval(x, y, 5, 5);
                    g.drawOval(x, y, 5, 5);
                    y+= 100;
                }
                y = 100;
                x+= 100;
            }

            for (int i = 0; i < node.length; i++) {
                for (int j = 0; j < node[i].length; j++) {
                    Node vertex = node[i][j];
                    if (vertex != null) {
                        g.setColor(Color.BLACK);
                        g.drawString(vertex.name, (vertex.x + 1) * 100 + 15, (vertex.y + 1) * 100 - 15);
                        g.drawOval((vertex.x + 1) * 100 - 5, (vertex.y + 1) * 100 - 5, 15, 15);
                    }
                }
            }

            for (int i = 0; i < node.length - 1; i++) {
                // System.out.println(node[i] +"<<<node[i]");
                for (int j = 0; j < node[i].length; j++) {
                    Node vertex = node[i][j];
                    if (vertex != null) {
                        // System.out.println(node[i][j].linkedVertices +"<<<node[i][j]");
                    int x = (vertex.x + 1) * 100;
                    int y = (vertex.y + 1) * 100;
                        g.setColor(Color.YELLOW);
                        
                        
                        for (int k = 0; k < vertex.linkedVertices.size(); k++) {
                            if(vertex.linkedVertices.get(k).x > 0){
                                Graphics2D g2 = (Graphics2D) g;
                                float thickness = 2; 
                                g2.setStroke(new BasicStroke(thickness));
                                g2.drawLine(x + 3, y + 3, (vertex.linkedVertices.get(k).x + 1) * 100 + 3, (vertex.linkedVertices.get(k).y + 1) * 100 + 3);
                            }
                        }

                    }
                }
            }

            for(Route r: routes){
                r.draw(g);
            }


            
            // for (int i = 0; i < path.size() - 1; i++) {
            //     int x = (path.get(i).x + 1) * 100;
            //     int y = (path.get(i).y + 1) * 100;
            //     System.out.println(x + "path" + y);
            //     g.setColor(Color.GREEN);
            //     Graphics2D g2 = (Graphics2D) g;
            //     float thickness = 2; 
            //     g2.setStroke(new BasicStroke(thickness));
            //     g2.drawLine(x + 3, y + 3, (path.get(i + 1).x + 1) * 100 + 3, (path.get(i + 1).y + 1) * 100 + 3);
            //     // try {
            //     //     // Sleep for 1 second (1000 milliseconds)
            //     //     Thread.sleep(1000);
            //     // } catch (InterruptedException e) {
            //     //     e.printStackTrace();
            //     // }
            // }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode()== KeyEvent.VK_UP){

            if (i < path.size() - 1) {
                int x = (path.get(i).x + 1) * 100;
                int y = (path.get(i).y + 1) * 100;
    
                Route route = new Route(this, i, x, y, path);
                routes.add(route);
                route.start();
                i++;
            }
            
        } 

    }    

    
}
