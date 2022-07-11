package method;

/**
 * @author Qbss
 * @date 2022/7/11
 * @desc
 */
public class Solution278 {

    //1,2,3(false),4(true),5(true)
    public int firstBadVersion(int n) {


        int startIndex = 1;
        int endIndex = n;

        while (endIndex >= startIndex) {
            int mid = (endIndex - startIndex) / 2 + startIndex;


            boolean badVersion = isBadVersion(mid);
            boolean badVersion1 = isBadVersion(mid - 1);
            if (badVersion && !badVersion1) {
                return mid;
            } else if (badVersion) {
                endIndex = mid - 1;
            } else {
                boolean badVersion2 = isBadVersion(mid + 1);
                if (!badVersion2) {
                    startIndex = mid + 1;
                } else {
                    return mid + 1;
                }
            }
        }
        return 0;
    }

    public int firstBadVersion1(int n) {

        int startIndex = 1;
        int endIndex = n;

        while (endIndex > startIndex) {

            int mid = (endIndex - startIndex) / 2 + startIndex;

            if (isBadVersion(mid)) {
                endIndex = mid;
            } else {
                startIndex = mid + 1;
            }
        }
        return startIndex;
    }


    static boolean isBadVersion(int version) {
        return version > 100;
    }

}
