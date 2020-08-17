package easy;

public class L557ReverseWords {
    public String L557(String s) {
        String[] splits = s.split(" ");
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (String split : splits) {
            temp.append(split);
            temp.reverse();
            temp.append(" ");
            builder.append(temp.toString());
            temp.setLength(0);
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
