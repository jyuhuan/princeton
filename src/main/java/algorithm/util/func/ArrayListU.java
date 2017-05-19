package algorithm.util.func;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Created by Yuhuan Jiang on 5/2/17.
 */
public class ArrayListU {
    public static <X> ArrayList<X> fill(int count, Supplier<X> x) {
        ArrayList<X> xs = new ArrayList<>(count);
        for (int i = 0; i < count; i++) xs.add(x.get());
        return xs;
    }
}
