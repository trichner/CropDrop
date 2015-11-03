package ch.k42.rand;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author trichner
 * https://stackoverflow.com/questions/6737283/weighted-randomness-in-java
 */
public class WeightedRandom<T> {
    private final Random rand;
    private final TreeMap<Object, Range<T>> ranges = new TreeMap<>(new RangeComparator());

    private int range;

    public WeightedRandom(List<WeightedItem<T>> weightedItems, Random rand) {
        this.rand = rand;
        int bottom = 0;
        for (WeightedItem<T> w : weightedItems) {
            if(w.weight>0){
                int top = bottom+w.weight-1;
                Range<T> r = new Range<>(bottom,top,w);
                ranges.put(r,r);
                bottom = top + 1;
            }
        }
        range = bottom;
    }

    public WeightedRandom(List<WeightedItem<T>> weightedItems) {
        this(weightedItems, new Random());
    }

    public T next(){
        Integer key = rand.nextInt(range);
        Range<T> r = ranges.get(key);
        return r == null ? null : r.item.item;
    }
}
