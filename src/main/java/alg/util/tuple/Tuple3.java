package alg.util.tuple;

/**
 * Created by Yuhuan Jiang on 5/2/17.
 */
public class Tuple3<X1, X2, X3> {
    private X1 x1;
    private X2 x2;
    private X3 x3;

    public Tuple3(X1 x1, X2 x2, X3 x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    public X1 get1() { return x1; }
    public X2 get2() { return x2; }
    public X3 get3() { return x3; }

    public void set1(X1 x1) { this.x1 = x1; }
    public void set2(X2 x2) { this.x2 = x2; }
    public void set3(X3 x3) { this.x3 = x3; }
    
}
