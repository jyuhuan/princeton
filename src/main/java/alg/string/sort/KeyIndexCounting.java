package alg.string.sort;

import alg.util.IntArrayU;
import alg.util.IterableU;
import alg.util.IteratorU;
import alg.util.ListU;
import alg.util.func.ArrayListU;
import alg.util.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * An efficient sorting algorithm for items keyed by small integers.
 * The keys should be any integer starting from 0 and less than a constant R. 
 */
public class KeyIndexCounting {
    
    public static <X> List<X> sort(List<X> xs, int r, Function<X, Integer> keySelector) {
        int[] counts = new int[r+1];
        for (X x: xs) counts[keySelector.apply(x) + 1] += 1;
        IntArrayU.scanInplace(counts, (x, y) -> x + y);
        
        ArrayList<X> res = ArrayListU.fill(xs.size(), () -> null);
        for (X x: xs) {
            int k = keySelector.apply(x);
            int idx = counts[k];
            counts[k] += 1;
            res.set(idx, x);
        }
        return res;
    }
    
    public static <X> void sortInplace(List<X> xs, int r, Function<X, Integer> keySelector) {
        List<X> sorted = sort(xs, r, keySelector);
        ListU.updateElementsWith(xs, sorted);
    }
    
    public static <X> List<X> sort(List<X> xs, Function<X, Integer> keySelector) {
        int max = 0;
        for (X x: xs) {
            int k = keySelector.apply(x);
            if (k > max) max = k;
        }
        return sort(xs, max + 1, keySelector);
    }

    public static <X> void sortInplace(List<X> xs, Function<X, Integer> keySelector) {
        List<X> sorted = sort(xs, keySelector);
        ListU.updateElementsWith(xs, sorted);
    }
    
}
