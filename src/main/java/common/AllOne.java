package common;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/3/16
 * @desc
 */
public class AllOne {


    private Map<String, Integer> stringMap = new HashMap<>();

    private Map<Integer, HashSet<String>> index = new HashMap<>();

    public AllOne() {

    }

    public void inc(String key) {
        if (this.stringMap.containsKey(key)) {
            Integer integer = this.stringMap.get(key);
            int value = integer + 1;
            this.stringMap.put(key, value);
            this.index.get(integer).remove(key);
            if (this.index.containsKey(value)) {
                this.index.get(value).add(key);
            } else {
                HashSet<String> strings = new HashSet<>();
                strings.add(key);
                this.index.put(value, strings);
            }

        } else {
            this.stringMap.put(key, 1);
            if (this.index.size() > 0) {
                this.index.get(1).add(key);
            } else {
                HashSet<String> strings = new HashSet<>();
                strings.add(key);
                this.index.put(1, strings);
            }

        }
    }

    public void dec(String key) {
        Integer integer = this.stringMap.get(key);
        if (integer == 1) {
            this.stringMap.remove(key);
            this.index.get(1).remove(key);
        } else {
            int value = integer - 1;
            this.stringMap.put(key, value);
            this.index.get(integer).remove(key);
            this.index.get(value).add(key);
        }
    }

    public String getMaxKey() {
        return index.get(Collections.max(index.keySet())).stream().findFirst().get();
    }

    public String getMinKey() {
        return index.get(Collections.min(index.keySet())).stream().findFirst().get();
    }

}
