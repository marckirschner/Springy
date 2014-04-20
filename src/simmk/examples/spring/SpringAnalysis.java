

package simmk.examples.spring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Observable;
import java.util.Observer;

public class SpringAnalysis implements Observer {   
    Spring spring;
    BufferedWriter fileOut;
        
    public SpringAnalysis(Spring spring) {
        this.spring = spring;
        
        try {
            FileWriter fstream = new FileWriter("spring_energy.txt");
            fileOut = new BufferedWriter(fstream);
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            System.exit(0);
        }
    }
    
    
    @Override
    public void update(Observable o, Object o1) {     
        this.writeToFile();
    }
    
     public void writeToFile()  {    
        try {
            System.out.println("Writing to File: " + spring.getEnergy());
            fileOut.write(""+spring.getEnergy()+"\n");
            fileOut.flush();
        } catch(java.io.IOException e) {
            System.out.println("" + e);
            System.exit(0);
            
        }
    }
        
}
