package oa;

public class PureStorage {
    // Complete the compute_number_score function below.
    static int compute_number_score(int number) {
        System.out.println("found 7: " + foundSeven(number));
        System.out.println("found c5: " + consecutiveFive(number));
        System.out.println("found sq: " + sequence(number));
        System.out.println("found m3: " + multipleThree(number));
        System.out.println("found even: " + evenDigit(number));


        return foundSeven(number) + consecutiveFive(number) + sequence(number) + multipleThree(number) + evenDigit(number);
    }

    static int foundSeven(int number) {
        int sum = 0;
        while (number > 0) {
            if (number % 10 == 7) {
                sum++;
            }
            number /= 10;
        }
        return sum;
    }

    static int consecutiveFive(int number) {
        int sum = 0;
        int consecutiveCount = 0;
        while (number > 0) {
            if (number % 10 == 5) {
                consecutiveCount++;
            } else {
                sum += 3 * (Math.max(0, consecutiveCount - 1));
                consecutiveCount = 0;
            }
            number /= 10;
        }
        sum += 3 * (Math.max(0, consecutiveCount - 1));
        return sum;
    }

    static int sequence(int number) {
        int sum = 0;
        if (number / 10 == 0) {
            return 1;
        }
        int lastDigit = number % 10;
        int sequenceCount = 1;
        number /= 10;

        while (number > 0) {
            int currDigit = number % 10;
            if (currDigit == lastDigit + 1) {
                sequenceCount++;
            } else {
                sum += sequenceCount * sequenceCount;
                sequenceCount = 1;
            }
            lastDigit = currDigit;
            number /= 10;
        }
        sum += sequenceCount * sequenceCount;
        return sum;
    }

    static int evenDigit(int number) {
        int sum = 0;
        if (number == 0) {
            return 4;
        }
        while (number > 0) {
            if (number % 2 == 0) {
                sum+= 4;
            }
            number /= 10;
        }
        return sum;
    }

    static int multipleThree(int number) {
        if (number % 3 == 0) {
            return 2;
        }
        return 0;
    }
}
