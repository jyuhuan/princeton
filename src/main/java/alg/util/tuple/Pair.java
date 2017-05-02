package alg.util.tuple;

/**
 * Created by Yuhuan Jiang on 5/2/17.
 */
public class Pair<A, B> {
    private A first;
    private B second;
    
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}
