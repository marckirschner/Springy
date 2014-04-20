package simmk.math;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.vecmath.Vector2d;
        
/**
 *
 * @author Nirgal
 */
public class Vector2dX extends Vector2d{
    public Vector2dX() {
        super(0,0);
    }
    public Vector2dX(double x, double y) {
        super(x,y);
    }
    public Vector2d add(Vector2d v) {
        return new Vector2d(this.x+v.x, this.y+v.y);
    }
    public Vector2d sub(Vector2d v) {
        return new Vector2d(this.x-v.x, this.y-v.y);
    }
}
