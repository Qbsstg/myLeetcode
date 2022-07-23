package method;

import java.util.*;
import java.util.stream.Collectors;

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
                if (this.valueToIndexs.containsKey(number)){
                    TreeSet<Integer> integers = this.valueToIndexs.get(number);
                    integers.add(index);
                    this.valueToIndexs.put(number,integers);
                }else {
                    TreeSet<Integer> integers = new TreeSet<>();
                    integers.add(index);
                    this.valueToIndexs.put(number,integers);
                }
            } else {
                this.indexToValue.put(index, number);
                if (this.valueToIndexs.containsKey(number)) {
                    TreeSet<Integer> list = this.valueToIndexs.get(number);
                    list.add(index);
                    this.valueToIndexs.put(number, list);
                } else {
                    TreeSet<Integer> list = new TreeSet<>();
                    list.add(index);
                    this.valueToIndexs.put(number, list);
                }
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
