package alg.util.func;

/**
 * Created by Yuhuan Jiang on 4/30/17.
 */
@FunctionalInterface
public interface Func2<X1, X2, Y> {
    Y apply(X1 x1, X2 x2);
}
