package alg.util;

import java.util.*;

/**
 * Created by Yuhuan Jiang on 5/2/17.
 */
public class ListU {
    
    public static <X> List<X> of(X... xs) {
        // Few items => linked list
        // Many items => array list
        if (xs.length < 10) {
            LinkedList<X> res = new LinkedList<>();
            Collections.addAll(res, xs);
            return res;
        }
        else {
            ArrayList<X> res = new ArrayList<>(xs.length);
            Collections.addAll(res, xs);
            return res;
        }

    }
    
    public static <X, Y extends X> void updateElementsWith(List<X> xs, List<Y> ys) {
        for (int i = 0; i < xs.size(); i++) xs.set(i, ys.get(i));
    }
    
}
