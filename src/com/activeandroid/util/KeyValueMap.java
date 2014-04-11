package com.activeandroid.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sschlicht on 10.04.14.
 */
public class KeyValueMap<K,V> {
    private Map<K, V> map =
            new HashMap<K, V>();

    public void addValue(K key, V value) {
        if (key == null)
            throw new NullPointerException("Type is null");
        map.put(key, value);
    }

    public <K,V> V getValue(K key) {
        return (V) map.get(key);
    }
}