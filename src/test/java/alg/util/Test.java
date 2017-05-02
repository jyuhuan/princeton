package alg.util;

import alg.util.func.Func2;

/**
 * Created by Yuhuan Jiang on 4/30/17.
 */
public class Test {
    
    public static void main(String[] args) {

        Func2<Integer, Integer, Integer> f = (x, y) -> x + y;
        
        Integer s = f.apply(2, 3);
        
        Iterable<String> scannedStrings = IterableU.scan(IterableU.of("A", "B", "C"), "z", (String x, String y) -> x + y);
        
        Iterable<Integer> scannedInts = IterableU.scan(IterableU.of(1, 2, 3, 4), 0, (Integer x, Integer y) -> x + y);
        
        String[] resStrings = IterableU.toArray(scannedStrings, String.class);
        
        Integer[] resInts = IterableU.toArray(scannedInts, Integer.class);
        
        int[] resIntSpecialized = IntArrayU.scan(new int[] {1,2,3,4}, 0, (x, y) -> x + y);
        
        int bp = 0;
    }
    
}
