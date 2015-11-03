package ch.k42.rand;

/**
 * @author trichner
 */
public class Range<T> implements Comparable<Object> {

    final int bottom,top;
    final WeightedItem<T> item;

    public Range(int bottom, int top, WeightedItem<T> item) {
        this.bottom = bottom;
        this.top = top;
        this.item = item;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Range<?>) {
            Range<?> other = (Range<?>) o;
            if(this.bottom > other.top)
                return 1;
            if(this.top < other.bottom)
                return -1;
            return 0; // overlapping ranges are considered equal.
        } else if (o instanceof Integer) {
            Integer other = (Integer) o;
            if(this.bottom > other.intValue())
                return 1;
            if(this.top < other.intValue())
                return -1;
            return 0;
        }
        throw new IllegalArgumentException(String.format("Cannot compare Range objects to %s objects.",
                o.getClass().getName()));
    }
}
