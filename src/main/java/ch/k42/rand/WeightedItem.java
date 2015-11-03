package ch.k42.rand;

/**
 * @author trichner
 */
public class WeightedItem<T> {
    final T item;
    final int weight;

    public WeightedItem(T item, int weight) {
        this.item = item;
        this.weight = weight;
    }
}
