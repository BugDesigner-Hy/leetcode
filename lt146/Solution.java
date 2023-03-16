package lt146;

/**
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1); // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2); // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1); // 返回 -1 (未找到)
 * lRUCache.get(3); // 返回 3
 * lRUCache.get(4); // 返回 4
 */
public class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(3, 3);
        cache.put(6, 6);
        cache.put(-1, -1);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);

    }
}
