package simmk.examples.spring;


import simmk.math.Vector2dX;
import simmk.draw.Drawable;
import simmk.math.Differentiable;

import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


public class Spring implements Drawable, Runnable {

    
    double mu=0;//5;
    double L=100; // natural length;
    double k=0.000001; // spring strength
    double m1=100; // mass 1 
    double m2=1; // mass 2
    
    public int m1Rad = 20;
    int m2Rad = 20; 
    
    public Vector2dX p1;
    public Vector2dX p2;
    
    public Vector2dX v1;
    public Vector2dX v2;
    
    
    double [] y1 = new double[100];
  
    
    public Spring()  {
        p1 = new Vector2dX(100,200);
        p2 = new Vector2dX(100,250);
        
        v1 = new Vector2dX(0,0);
    }
    
    public void draw(Graphics g) {
        g.fillOval((int)p1.x, (int)p1.y, m1Rad, m1Rad);
        g.fillOval((int)p2.x, (int)p2.y, m2Rad, m2Rad);
        g.drawLine((int)p1.x+m1Rad/2,(int)p1.y, (int)p2.x+m2Rad/2, (int)p2.y);
        
    }
    
    public void applyHookesLaw() {
       
        double force_y = -1*k*(L - Math.abs(p1.y-p2.y) ) - mu*v1.y;
        double a = force_y/m1;
    
        v1.y+= a*0.001;      
        p1.y+=v1.y*0.001;
    //    System.out.println("HOOKES LAW");
    }
    
    public double getEnergy() {
         return ( ( 0.5*m1*v1.y*v1.y + 0.5*k*(L - Math.abs(p1.y-p2.y))*(L - Math.abs(p1.y-p2.y))));
    }
    
  /*  @Override
    public void update(Observable o, Object o1) {
        applyHookesLaw();
    }*/
    
    public void run() {
        System.out.println("RUN");
        while (true) {
            applyHookesLaw();
        }
    }
    
    
    
    public void rungaKuttaODE() {
       
    }
}
