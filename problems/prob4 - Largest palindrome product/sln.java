import java.lang.Math;

class Main {
    public static void main(String[] args) {
        int digit_count = 3;
        int largest = 0;
        for(int x = 0; x < Math.pow(10, digit_count); x++) {
            for(int y = 0; y < Math.pow(10, digit_count); y++) {
                int product = x * y;
                if(product > largest && is_palindrome(product)) {
                    largest = product;
                }
            }
        }
        System.out.println(largest);
    }

    public static boolean is_palindrome(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int midpoint = arr.length / 2;
        for(int i = 0; i < midpoint; i++) {
            if(arr[i] != arr[arr.length-1-i]) {
                return false;
            }
        }

        return true;
    }
}
