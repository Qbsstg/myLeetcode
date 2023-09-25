package method;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Qbss
 * @date: 2023/9/25
 * @desc:
 */
public class Solution460 {

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    static class LFUCache {

        class LFCElem {
            int key;
            int value;
            int freq;

            LocalDateTime lastUseTime;

            public LFCElem(int key, int value, int freq) {
                this.key = key;
                this.value = value;
                this.freq = freq;
            }

            public LFCElem(int key, int value, int freq, LocalDateTime lastUseTime) {
                this.key = key;
                this.value = value;
                this.freq = freq;
                this.lastUseTime = lastUseTime;
            }
        }

        Queue<LFCElem> queue;

        Map<Integer, LFCElem> map;

        int capacity;

        public LFUCache(int capacity) {
            this.queue = new PriorityQueue<>((lfc1, lfc2) -> {
                if (lfc1.freq == lfc2.freq) {
                    return lfc1.lastUseTime.compareTo(lfc2.lastUseTime);
                }
                return lfc1.freq - lfc2.freq;
            });
            this.map = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!this.map.isEmpty()) {
                LFCElem lfcElem = this.map.get(key);
                if (lfcElem != null) {
                    queue.remove(lfcElem);
                    lfcElem.freq += 1;
                    lfcElem.lastUseTime = LocalDateTime.now();
                    queue.offer(lfcElem);
                    return lfcElem.value;
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            //先判断是否存在，如果存在，直接修改值
            if (!this.map.isEmpty()) {
                LFCElem lfcElem = this.map.get(key);
                //如果已经存在了，不判断capacity大小，直接修改值
                if (lfcElem != null) {
                    queue.remove(lfcElem);
                    lfcElem.value = value;
                    lfcElem.freq += 1;
                    lfcElem.lastUseTime = LocalDateTime.now();
                    queue.offer(lfcElem);
                    map.put(key, lfcElem);
                } else {
                    //如果还没有存在过，则进行capacity大小的判断，以保证不会出现超过容量大小的情况
                    if (this.map.size() == capacity) {
                        //需要先移除一个，然后再进行添加
                        LFCElem peek = this.queue.peek();
                        //判断一个异常，假如队列存在问题，或者队首为null，需要处理这种异常
                        if (peek != null) {
                            //在map中移除一个对象
                            this.map.remove(peek.key);
                            this.queue.remove();
                            //移除成功后，开始新增
                            LFCElem addElem = new LFCElem(key, value, 1, LocalDateTime.now());
                            this.map.put(key, addElem);
                            this.queue.add(addElem);
                        }
                    } else {
                        //如果还未超过容量，直接添加
                        LFCElem addElem = new LFCElem(key, value, 1, LocalDateTime.now());
                        this.map.put(key, addElem);
                        this.queue.add(addElem);
                    }
                }
            } else {
                //map为空，刚初始化完，判断capacity大小
                if (capacity != 0) {
                    LFCElem addElem = new LFCElem(key, value, 1, LocalDateTime.now());
                    this.map.put(key, addElem);
                    this.queue.add(addElem);
                }
            }
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.get(1);
        lfuCache.put(3,3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4,4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }


}
