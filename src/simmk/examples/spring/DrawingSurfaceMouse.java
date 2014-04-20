package simmk.examples.spring;



import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import simmk.draw.DrawingSurface;


public class DrawingSurfaceMouse extends DrawingSurface implements MouseMotionListener {

 
    int mouseX;
    int mouseY;
    
    Spring spring;
    
    public DrawingSurfaceMouse(Spring spring) {
        this.spring = spring;
        addMouseMotionListener(this);
       
    }
    
       @Override
    public void mouseDragged(MouseEvent me) {
        
        mouseX = me.getX();
        mouseY = me.getY();
        
       // if (mouseY > spring.p1.y &&  ( mouseY < (spring.p1.y+spring.m1Rad) ) ) {
            spring.v1.y=0;
           // spring.p1.x=mouseX;
            spring.p1.y=mouseY;
        
       // }
                
    }

    @Override
    public void mouseMoved(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
            
        // Close the file handle after closing
       
}
