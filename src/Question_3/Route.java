package Question_3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Route extends Thread {
  Panel panel;

  int i;
  int x; 
  int y;  
  List<Node> path;
  public Route(Panel panel, int i, int x, int y, List<Node> path) {
        this.panel = panel;
        this.i = i;
        this.x = x;
        this.y = y;
        this.path = path;
      }

      
  @Override
  public void run() {
      panel.repaint();
  }



  public void draw(Graphics g){
      

    g.setColor(Color.GREEN);
        Graphics2D g2 = (Graphics2D) g;
        float thickness = 2; 
        g2.setStroke(new BasicStroke(thickness));
        g2.drawLine(x + 3, y + 3, (path.get(i + 1).x + 1) * 100 + 3, (path.get(i + 1).y + 1) * 100 + 3);

      g.fillOval(x, y, 5, 5);
      g.fillOval((path.get(i + 1).x + 1) * 100, (path.get(i + 1).y + 1) * 100, 5, 5);
  }


}
