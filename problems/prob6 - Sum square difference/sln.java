import java.lang.Math;

class Main {
    public static void main(String[] args) {
        System.out.println(square_of_sum(100) - sum_of_square(100));
    }

    public static Integer square_of_sum(int n) {
        Integer sum = (n / 2) * (1 + n);
        return sum * sum;
    }

    public static Integer sum_of_square(int n) {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }
}
