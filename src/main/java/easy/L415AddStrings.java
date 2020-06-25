package easy;

public class L415AddStrings {
    public String addStrings(String num1, String num2) {
        int index = 0;
        int increment = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(num1);
        num1 = builder.reverse().toString();
        builder.setLength(0);
        builder.append(num2);
        num2 = builder.reverse().toString();
        builder.setLength(0);



        while (index < Math.min(num1.length(), num2.length())) {
            int digit1 = num1.charAt(index) - '0';
            int digit2 = num2.charAt(index) - '0';
            int sum = digit1 + digit2 + increment;
            if (sum >= 10) {
                increment = 1;
                sum = sum % 10;
            } else {
                increment = 0;
            }
            builder.append(sum);
            index++;
        }

        if (num1.length() != num2.length()) {
            String longer = num1.length() > num2.length() ? num1 : num2;
            while (index < longer.length()) {
                int digit = longer.charAt(index) - '0';
                int sum = digit + increment;
                if (sum >= 10) {
                    increment = 1;
                    sum = sum % 10;
                } else {
                    increment = 0;
                }
                builder.append(sum);
                index++;
            }
        }
        if (increment == 1) {
            builder.append(increment);
        }

        return builder.reverse().toString();


    }


}
