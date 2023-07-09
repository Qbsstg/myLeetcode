package test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class test9 {


    /*
     *1.	有如下的字符串数组，每个字符串的格式为：词性:单词，根据单词的词性，将动词的单词全部存入verb.txt文件中，将名词的单词全部存入noun.txt文件中。
     *
     * */
    public void dealStr(String[] strings) throws IOException {

        if (strings == null) {
            return;
        }

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (String s : strings) {
            String[] split = s.split(":");
            if (split[0].equals("动词")) {
                list1.add(s);
            } else if (split[1].equals("名词")) {
                list2.add(s);
            }
        }


        File verbFile = new File("verb.txt");
        File nounfile = new File("noun.txt");


        Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(verbFile), StandardCharsets.UTF_8));
        for (String s : list1) {
            out1.write(s + "\r\n");
        }

        Writer out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nounfile), StandardCharsets.UTF_8));
        for (String s : list2) {
            out2.write(s + "\r\n");
        }

        out1.flush();
        out1.close();
        out2.flush();
        out1.close();

    }

}
