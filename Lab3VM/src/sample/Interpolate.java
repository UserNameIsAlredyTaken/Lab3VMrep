package sample;

/**
 * Created by danil on 06.11.2017.
 */
public class Interpolate{
    public double polinomValue(int n,double[] x, double[] a, double t){
        double S = a[0];
        double p = 1;
        for(int i = 1;i<=n;i++){
            p*=(t-x[i-1]);
            S+=a[i]*p;
        }
        return S;
    }
    public double[] computeCoef(int n, double[] x, double[] y){
        double[] a = new double[n+1];
        a[0] = y[0];
        for(int i = 1; i<=n; i++){
            double p = 1;
            for(int j = 0; j<i;j++){
                p*=(x[i]-x[j]);
            }
            a[i]=(y[i]-polinomValue(i-1, x, a, x[i]))/p;
        }
        return a;
    }
}
