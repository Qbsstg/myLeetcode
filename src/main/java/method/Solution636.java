package method;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Solution636 {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
        System.out.println(Arrays.toString(exclusiveTime(1, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"))));
        System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"))));
        System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"))));
        System.out.println(Arrays.toString(exclusiveTime(1, Arrays.asList("0:start:0", "0:end:0"))));
        System.out.println(Arrays.toString(exclusiveTime(8, Arrays.asList(
                "0:start:0",
                "1:start:5",
                "2:start:6",
                "3:start:9",
                "4:start:11",
                "5:start:12",
                "6:start:14",
                "7:start:15",
                "1:start:24",
                "1:end:29",
                "7:end:34",
                "6:end:37",
                "5:end:39",
                "4:end:40",
                "3:end:45",
                "0:start:49",
                "0:end:54",
                "5:start:55",
                "5:end:59",
                "4:start:63",
                "4:end:66",
                "2:start:69",
                "2:end:70",
                "2:start:74",
                "6:start:78",
                "0:start:79",
                "0:end:80",
                "6:end:85",
                "1:start:89",
                "1:end:93",
                "2:end:96",
                "2:end:100",
                "1:end:102",
                "2:start:105",
                "2:end:109",
                "0:end:114"
        ))));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {

        int[] res = new int[n];

        List<LogInfo> logInfos = logs.stream().map(x -> {
            String[] split = x.split(":");
            boolean status = split[1].equals("start");
            LogInfo logInfo = new LogInfo(split[0], status);
            logInfo.time = Integer.parseInt(split[2]);
            return logInfo;
        }).collect(Collectors.toList());

        Deque<LogInfo> deque = new ArrayDeque<>();


        for (LogInfo logInfo : logInfos) {
            if (deque.isEmpty()) {
                deque.offer(logInfo);
            } else {
                LogInfo peek = deque.peekLast();
                if (!logInfo.status) {
                    res[peek.mark] = res[peek.mark] + logInfo.time - peek.time + 1;
                    deque.pollLast();
                    if (!deque.isEmpty()) {
                        deque.peekLast().time = logInfo.time + 1;
                    }
                } else {
                    if (peek.status) {
                        res[peek.mark] += logInfo.time - peek.time;
                    }
                    deque.offer(logInfo);
                }
            }
        }
        return res;
    }

    static class LogInfo {

        int mark;

        //false代表结束,true代表开始
        Boolean status;

        int time;


        public LogInfo(String s, boolean status) {
            this.mark = Integer.parseInt(s);
            this.status = status;
        }
    }

}
