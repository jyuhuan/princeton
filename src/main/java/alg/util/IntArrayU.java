package alg.util;

import alg.util.func.Func2;

/**
 * Created by Yuhuan Jiang on 5/2/17.
 */
public class IntArrayU {

    public static int[] scan(int[] ints, int seed, Func2<Integer, Integer, Integer> op) {
        int[] res = new int[ints.length + 1];
        res[0] = seed;
        for (int i = 1; i < res.length; i++) {
            res[i] = op.apply(res[i-1], ints[i-1]);
        }
        return res;
    }

    /**
     * @param ints ints[0] is the seed.
     */
    public static void scanInplace(int[] ints, Func2<Integer, Integer, Integer> op) {
        for (int i = 1; i < ints.length; i++) {
            ints[i] = op.apply(ints[i], ints[i-1]);
        }
    }
    
}
