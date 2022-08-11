package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/11
 * @desc
 */
public class Solution1417 {

    public String reformat(String s) {

        char[] chars = s.toCharArray();

        List<Character> nums1 = new ArrayList<>();
        List<Character> nums2 = new ArrayList<>();

        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                nums1.add(aChar);
            } else {
                nums2.add(aChar);
            }
        }

        if (Math.abs(nums1.size() - nums2.size()) > 1) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (nums1.size() >= nums2.size()) {
            for (int i = 0; i < nums1.size(); i++) {
                stringBuilder.append(nums1.get(i));
                if (i < nums2.size()){
                    stringBuilder.append(nums2.get(i));
                }
            }
        }else {
            for (int i = 0; i < nums2.size(); i++) {
                stringBuilder.append(nums2.get(i));
                if (i < nums1.size()){
                    stringBuilder.append(nums1.get(i));
                }
            }
        }
        return stringBuilder.toString();
    }

}
