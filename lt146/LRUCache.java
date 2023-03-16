package lt146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer,Integer> store ;

    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.store = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if(!store.containsKey(key)){
            return -1;
        }
        makeRencentlyKey(key);
        return store.get(key);
    }

    private void makeRencentlyKey(int key) {
        Integer value = store.get(key);
        store.remove(key);
        store.put(key,value);
    }

    public void put(int key, int value) {

        if(store.containsKey(key)){
            store.put(key,value);
            makeRencentlyKey(key);
            return;
        }

        if(store.size()==capacity){
            Integer head = store.keySet().iterator().next();
            store.remove(head);
        }
        store.put(key,value);
    }

    public Map<Integer, Integer> getStore() {
        return this.store;
    }
}
