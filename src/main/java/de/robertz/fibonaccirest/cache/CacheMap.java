package de.robertz.fibonaccirest.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of a Map with fixed capacity. If the Map would grow over the capacity the least recently used Element is removed
 *
 * @param <K>
 * @param <V>
 */
public class CacheMap<K, V> extends LinkedHashMap<K, V> {

    /**
     * constant factor for the map size. This needs to be done to avoid to many collisions
     */
    private static final float INCREASE = 1.3f;

    private final int capacity;

    /**
     * Constructs an empty CacheMap instance with the specified capacity
     *
     * @param capacity the capacity of the cache
     * @throws IllegalArgumentException if capacity is less than 1
     */
    public CacheMap(int capacity) {
        super((int) (capacity * INCREASE), 1.0f, true);
        if (capacity < 1) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
