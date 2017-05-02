package alg.util;

import alg.util.func.Func2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Yuhuan Jiang on 4/30/17.
 */
public class IterableU {
    
    static <X> Iterable<X> of(X... xs) {
        return ListU.of(xs);
    }
    
    static <X> Iterable<X> fromIterator(Supplier<Iterator<X>> iter) {
        return iter::get;
    }
    
    static <X> X[] toArray(Iterable<X> xs, Class<X> clazz) {
        LinkedList<X> list = new LinkedList<>();
        for (X x: xs) list.add(x);
        X[] arr = (X[]) Array.newInstance(clazz, list.size());
        int i = 0;
        for (X x: list) {
            arr[i] = x;
            i += 1;
        }
        return arr;
    }
    
    static <X> Iterable<X> scan(Iterable<X> xs, X seed, Func2<X, X, X> op) {
        return fromIterator(() -> new Iterator<X>() {
            boolean first = true;
            X last = seed;
            Iterator<X> iter = xs.iterator();
            @Override
            public boolean hasNext() {
                return first || iter.hasNext();
            }
            @Override
            public X next() {
                if (first) {
                    first = false;
                    return seed;
                }
                else {
                    X next = iter.next();
                    last = op.apply(last, next);
                    return last;
                }
            }
        });
    }
    
    
}
