package hackerRankContest;

public class HighSecurityString {
    public static int getStrength(String password, int weight_a) {
        // Complete the function
        int[] weight = new int[26];
        int currWeight = weight_a;
        for (int i = 0; i < weight.length; i++) {
            weight[i] = currWeight % 26;
            currWeight++;
        }
        int strength = 0;
        for (int i = 0; i < password.length();i++) {
            char c = password.charAt(i);
            int w = weight[c - 'a'];
            strength += w;
        }
        return strength;

    }


}
