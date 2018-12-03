package com.news.utils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;


/**
 * @ClassName NewsPictureMap
 * @Author One_llx
 * @Date 2018/12/2 0002 下午 1:05
 * @Version 1.0
 */
public interface NewsPictureMap<K,V> extends Map<K, List<V>> {

    /**
     * Return the first value for the given key.
     * @param key the key
     * @return the first value for the specified key, or {@code null}
     */
    V getFirst(K key);

    /**
     * Add the given single value to the current list of values for the given key.
     * @param key the key
     * @param value the value to be added
     */
    void add(K key, V value);

    /**
     * Set the given single value under the given key.
     * @param key the key
     * @param value the value to set
     */
    void set(K key, V value);

    /**
     * Set the given values under.
     * @param values the values.
     */
    void setAll(Map<K, V> values);

    /**
     * Returns the first values contained in this {@code MultiValueMap}.
     * @return a single value representation of this map
     */
    Map<K, V> toSingleValueMap();

}
