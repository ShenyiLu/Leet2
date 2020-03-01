package medium;

public class L165CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] version1Str = version1.split("\\.");
        String[] version2Str = version2.split("\\.");
        int index = 0;
        while (index < version1Str.length || index < version2Str.length) {
            int v1 = 0;
            int v2 = 0;
            if (index < version1Str.length) {
                v1 = Integer.parseInt(version1Str[index]);
            }
            if (index < version2Str.length) {
                v2 = Integer.parseInt(version2Str[index]);
            }
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }

            index++;
        }
        return 0;
    }
}
