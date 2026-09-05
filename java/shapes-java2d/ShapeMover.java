package dinovacao;


import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
//Use double buffering to remove rectangle flickers and make it repaint faster.
public class ShapeMover extends JApplet {
  static protected Label label = new Label(
      "Drag rectangle around within the area");

  public void init() {

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(new MyCanvas());

    getContentPane().add("South", label);
  }

  public static void main(String s[]) {
    Frame f = new Frame("ShapeMover");
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Applet applet = new ShapeMover();
    f.add("Center", applet);
    applet.init();
    f.pack();
    f.setSize(new Dimension(1250, 700));
    f.show();
  }
}
