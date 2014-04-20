package simmk.draw;


import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JPanel;
import java.util.Observer;



public abstract class DrawingSurface extends JPanel implements Observer {
    
    ArrayList<Drawable> drawableList = new ArrayList<Drawable>();
     
    public void addDrawable(Drawable drawableObject) {
        this.drawableList.add(drawableObject);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);   
        
        for (Drawable drawableObject : drawableList) {
            drawableObject.draw(g);
        }
    }  
    
    @Override
    public Dimension getPreferredSize() {
        int x=600;
        int y=400;
        return new Dimension(x,y);
    }
      
    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }
    

}
