package alg.util;

import alg.util.func.Func2;
import alg.util.tuple.Pair;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;

/**
 * 
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
    
    public static <X> Iterable<Pair<Integer, X>> indexed(Iterable<X> xs) {
        return IterableU.fromIterator(() -> new Iterator<Pair<Integer, X>>() {
            Iterator<X> iter = xs.iterator();
            int idx = 0;
            
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Pair<Integer, X> next() {
                int i = idx;
                idx += 1;
                return new Pair(i, iter.next());
            }
        });
    } 
    
    public static <X, Y, Z> Iterable<Z> zippedWith(Iterable<X> xs, Iterable<Y> ys, Func2<X, Y, Z> f) {
        return IterableU.fromIterator(() -> new Iterator<Z>() {
            Iterator<X> xi = xs.iterator();
            Iterator<Y> yi = ys.iterator();
            
            @Override
            public boolean hasNext() {
                return xi.hasNext() && yi.hasNext();
            }

            @Override
            public Z next() {
                return f.apply(xi.next(), yi.next());
            }
        });
    }
    
    public static <X, Y> Iterable<Pair<X, Y>> zipped(Iterable<X> xs, Iterable<Y> ys) {
        return zippedWith(xs, ys, Pair::new);
    }
    
    
    
}
