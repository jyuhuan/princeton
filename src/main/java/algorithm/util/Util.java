package algorithm.util;

/**
 * Created by Yuhuan Jiang on 5/16/17.
 */
public class Util {

    public static int nextPowerOfTwo(int n) {
        int c = n - 1;
        c |= c >>> 1;
        c |= c >>> 2;
        c |= c >>> 4;
        c |= c >>> 8;
        c |= c >>> 16;
        return c + 1;
    }

}
