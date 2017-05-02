package alg.util;

import alg.util.func.Func;

import java.util.Iterator;

/**
 * Created by Yuhuan Jiang on 5/2/17.
 */
public class IteratorU {

    //region HIGHER-ORDER FUNCTIONS

    public static <X, Y> Iterator<Y> map(Iterator<X> iter, Func<X, Y> f) {
        return new Iterator<Y>() {
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Y next() {
                return f.apply(iter.next());
            }
        };
    }
    
    //endregion

}
