package method;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution6130 {

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();

        numberContainers.change(1, 10);

        numberContainers.find(10);
        numberContainers.change(1, 20);
        numberContainers.find(10);
        numberContainers.find(20);
        numberContainers.find(30);
    }

    static class NumberContainers {

        Map<Integer, Integer> indexToValue;
        Map<Integer, TreeSet<Integer>> valueToIndexs;


        public NumberContainers() {
            this.indexToValue = new HashMap<>();
            this.valueToIndexs = new HashMap<>();
        }

        public void change(int index, int number) {
            if (this.indexToValue.containsKey(index)) {
                Integer value = this.indexToValue.get(index);
                this.indexToValue.put(index, number);

                Set<Integer> indexs = this.valueToIndexs.get(value);
                indexs.remove(index);
                if (indexs.size() == 0){
                    this.valueToIndexs.remove(value);
                }
                TreeSet<Integer> integers;
                if (this.valueToIndexs.containsKey(number)){
                    integers = this.valueToIndexs.get(number);
                }else {
                    integers = new TreeSet<>();
                }
                integers.add(index);
                this.valueToIndexs.put(number,integers);
            } else {
                this.indexToValue.put(index, number);
                TreeSet<Integer> list;
                if (this.valueToIndexs.containsKey(number)) {
                    list = this.valueToIndexs.get(number);
                } else {
                    list = new TreeSet<>();
                }
                list.add(index);
                this.valueToIndexs.put(number, list);
            }
        }

        public int find(int number) {
            if (this.valueToIndexs.containsKey(number)) {

                Set<Integer> list = this.valueToIndexs.get(number);
                return list.stream().findFirst().get();
            } else {
                return -1;
            }
        }
    }

}
