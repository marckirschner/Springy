package simmk.event;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.Observable;

public class Pulse extends Observable implements ActionListener {

    Timer timer;
    static int counter = 0;

    public Pulse(int delay) {
        timer = new Timer(delay, this);
    }

    public void start() {
        System.out.println("Starting timer");
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setChanged();
        this.notifyObservers(ae);
    }
}
