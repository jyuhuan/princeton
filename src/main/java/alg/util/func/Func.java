package alg.util.func;

/**
 * Created by Yuhuan Jiang on 4/30/17.
 */

@FunctionalInterface
public interface Func<X, Y> {
    Y apply(X x);
}
