package com.ttyc.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1L;
    protected int maxElements;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxElements = maxSize;
    }

    /**
     * 达到最大容量就移除链表头部元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxElements;
    }
}