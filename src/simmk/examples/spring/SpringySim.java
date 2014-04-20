package simmk.examples.spring;


import simmk.draw.DrawingSurface;
import simmk.event.Pulse;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SpringySim {
       
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
    
    
     private static void createAndShowGUI() {
        
         
        Spring spring = new Spring();
        
        
        DrawingSurface drawingSurface = new DrawingSurfaceMouse(spring);  
        drawingSurface.addDrawable(spring);
        
        SpringAnalysis springAnalysis = new SpringAnalysis(spring);
        
        
     //   ODEEuler = new ODEEuler(Spring);
        
        Thread thread = new Thread(spring);
        thread.start();
        
        
        Pulse pulse = new Pulse(100/3);
        pulse.addObserver(drawingSurface);
        
        /*Pulse pulse2 = new Pulse(0);
        pulse2.addObserver(spring);*/
        
        
      //  Pulse pulse3 = new Pulse(100);
      //  pulse3.addObserver(springAnalysis);
       
        
        pulse.start();
      //  pulse2.start();
       // pulse3.start();
   
        
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Graphical Model");
        // Set Location
         
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        f.setLocation(dim.width/10,dim.height/10);
                
                
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(drawingSurface);
        f.pack();
        
        f.setVisible(true);
       
        
    }
}
