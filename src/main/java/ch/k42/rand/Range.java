package ch.k42.rand;

/**
 * @author trichner
 */
public class Range<T>{
    final int bottom,top;
    final WeightedItem<T> item;

    public Range(int bottom, int top, WeightedItem<T> item) {
        this.bottom = bottom;
        this.top = top;
        this.item = item;
    }
}
