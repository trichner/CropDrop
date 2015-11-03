package ch.k42.rand;

import java.util.Comparator;

/**
 * @author Thomas
 * @version radio-tower-plugin 03.11.2015.
 */
public class RangeComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Range<?> r;
        if (o1 instanceof Range<?>) {
            r = (Range<?>) o1;
            return compareRange(r, o2);
        } else if (o2 instanceof Range<?>) {
            r = (Range<?>) o2;
            return -compareRange(r, o1);
        } else {
            throw new IllegalArgumentException(String.format("No range to compare found"));
        }

    }

    private int compareRange(Range<?> r,Object o){
        if (o instanceof Range<?>) {
            Range<?> other = (Range<?>) o;
            if (r.bottom > other.top)
                return 1;
            if (r.top < other.bottom)
                return -1;
            return 0; // overlapping ranges are considered equal.
        } else if (o instanceof Integer) {
            Integer other = (Integer) o;
            if (r.bottom > other)
                return 1;
            if (r.top < other)
                return -1;
            return 0;
        }
        throw new IllegalArgumentException(String.format("Cannot compare Range objects to %s objects.",
                o.getClass().getName()));
    }
}
