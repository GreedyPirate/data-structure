package com.ttyc.algorithm.lru;

public class TestCase {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(5);
        cache.put("aa",1);
        cache.put("bb",2);
        cache.put("cc",3);
        cache.put("dd",4);
        cache.put("ee",5);
        cache.put("ff",6);

        cache.get("dd");
        cache.get("bb");

        cache.entrySet().forEach(t -> {
            System.out.println("t = " + t.getKey());
        });
    }
}
