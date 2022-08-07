package method;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Solution636 {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
        //System.out.println(Arrays.toString(exclusiveTime(1, Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"))));
        //System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"))));
        System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"))));
        //System.out.println(Arrays.toString(exclusiveTime(1, Arrays.asList("0:start:0","0:end:0"))));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {

        int[] res = new int[n];

        List<logInfo> logInfos = logs.stream().map(x -> {
            String[] split = x.split(":");
            boolean status = split[1].equals("start");
            logInfo logInfo = new logInfo(split[0], status);
            if (status) {
                logInfo.startTime = Integer.parseInt(split[2]);
            } else {
                logInfo.endTime = Integer.parseInt(split[2]);
            }
            return logInfo;
        }).collect(Collectors.toList());

        Deque<logInfo> deque = new ArrayDeque<>();

        int end = 0;
        for (int i = 0; i < logInfos.size(); i++) {
            logInfo logInfo = logInfos.get(i);
            if (deque.isEmpty()) {
                deque.offer(logInfo);
            } else {
                logInfo peek = deque.peekLast();
                if (peek.mark == logInfo.mark && !logInfo.status) {
                    int diff;
                    if (peek.endTime == 0) {
                        diff = logInfo.endTime - peek.startTime + 1;
                    } else {
                        diff = peek.endTime - peek.startTime  + logInfo.endTime - end;
                    }
                    res[peek.mark] = res[peek.mark] + diff;
                    end = logInfo.endTime;
                    deque.pollLast();
                } else {
                    if (peek.endTime == 0){
                        peek.endTime = logInfo.startTime;
                    }
                    deque.offer(logInfo);
                }
            }
        }
        return res;
    }

    static class logInfo {

        int mark;

        //false代表结束,true代表开始
        Boolean status;

        int startTime;

        int endTime;


        public logInfo(String s, boolean status) {
            this.mark = Integer.parseInt(s);
            this.status = status;
        }
    }

}
