package contest.biweekly.b85;

public class Solution3 {


    public static String shiftingLetters(String s, int[][] shifts) {


        char[] chars = s.toCharArray();
        int[] diff = new int[chars.length];

        diff[0] = chars[0];
        for (int i = 1; i < chars.length; i++) {
            diff[i] = chars[i] - chars[i - 1];
        }

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                diff[shift[0]] += 1;
                if (shift[1] + 1 < diff.length) {
                    diff[shift[1] + 1] -= 1;
                }
            } else {
                diff[shift[0]] -= 1;
                if (shift[1] + 1 < diff.length) {
                    diff[shift[1] + 1] += 1;
                }
            }
        }

        int[] res = new int[chars.length];
        char[] ans = new char[chars.length];

        res[0] = diff[0];
        //ans[0] = (char) (chars[0] + ((res[0] - chars[0]) % 26));
        for (int i = 0; i < diff.length; i++) {
            if (i - 1 >= 0) {
                res[i] = res[i - 1] + diff[i];
            }
            if (res[i] <= 122 && res[i] >= 97) {
                ans[i] = (char) res[i];
            } else {
                if (res[i] < 97) {
                    ans[i] = (char) (((res[i] - 97) % 26) + 123);
                } else {
                    ans[i] = (char) (((res[i] - 122) % 26) + 96);
                }
            }
        }
        return new String(ans).replace("{","a").replace("`","z");
    }

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "dztz";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        int[][] shifts1 = {{0, 0, 0}, {1, 1, 1}};
        System.out.println(shiftingLetters(s1, shifts1));

        String s2 =
                "zrjymczgokycagmjltauchgwxdpsbctdfikwrlfggqxzrkykihenpkynsqwiskiusgqopfozhvwqfneyhtcyzmlhokrjdemqjzokxhlcrpfkanroixlfxcniordgkcfdjtowortyluxhrrfeqezplrabmudtbavcgufxjdtjwkyyiqsysqqbmrpwaodhnziuosagvzivfqndnrmvnkwqfaweuzvaawwdxxmmeupxnfruridsqswrvnvhxcbmzynuhkuxzdfinbkiemlbcwplqrrciqfynnbwqnyhowdiocqgerrkmalnajyophswierbfleoczftutywwbzibivklyjpqzsizjkooxgfkbyfmsjcaxddzmwnmydjelpryjxzdvyaiwzjgecxckidwybtnsjvfhruxqhtwprvslelteuzdgmauvbypqsszjtefgxpbcoydkdyyw{scpltepsyeoxqbgnjfknvkbmepbgobuxhxozkpmeugudmyp{kpnjrdqfwjrwq{hzumel{ofzcftlguphcgvxydeuxukduqhlczwrspuzaetbn{erzxcgriijvkpujzusqgxbbaxfaczdkurusvdtxl";

        String s3 =
                "zrjymczgokycagmjltauchgwxdpsbctdfikwrlfggqxzrkykihenpkynsqwiskiusgqopfozhvwqfneyhtcyzmlhokrjdemqjzokxhlcrpfkanroixlfxcniordgkcfdjtowortyluxhrrfeqezplrabmudtbavcgufxjdtjwkyyiqsysqqbmrpwaodhnziuosagvzivfqndnrmvnkwqfaweuzvaawwdxxmmeupxnfruridsqswrvnvhxcbmzynuhkuxzdfinbkiemlbcwplqrrciqfynnbwqnyhowdiocqgerrkmalnajyophswierbfleoczftutywwbzibivklyjpqzsizjkooxgfkbyfmsjcaxddzmwnmydjelpryjxzdvyaiwzjgecxckidwybtnsjvfhruxqhtwprvslelteuzdgmauvbypqsszjtefgxpbcoydkdyywascpltepsyeoxqbgnjfknvkbmepbgobuxhxozkpmeugudmypakpnjrdqfwjrwqahzumelaofzcftlguphcgvxydeuxukduqhlczwrspuzaetbnaerzxcgriijvkpujzusqgxbbaxfaczdkurusvdtxl";


        String[] split = s2.split("");
        String[] split1 = s3.split("");
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals(split1[i])){
                System.out.println(i+"--->"+split1[i]+"---->"+split[i]);
                break;
            }
        }

    }


}
