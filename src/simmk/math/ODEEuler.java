

package simmk.math;

public class ODEEuler {
    // t = {begTime, endTime, timeStep}
    public void solve(double [] t, double [] q, double [] p) {
        double [] q2 = new double[ (int)((t[1]-t[0])/t[3]) ];
        double [] p2 = new double[ (int)((t[1]-t[0])/t[3]) ]; 
        for (int i=0; i<q.length; i++) {
            q2[i] = q[i] + p[i]*t[2];
            
        }
    }
}
