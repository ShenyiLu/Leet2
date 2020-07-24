package easy;

public class L509FibonacciNumber {
    public int fib(int N) {
        double squareFive = Math.sqrt(5.0);
        double first = (1 + squareFive) / 2;
        double second = (1 - squareFive) / 2;

        double result = (1 / squareFive) * (Math.pow(first, N) - Math.pow(second, N));

        return (int) result;
    }
}
