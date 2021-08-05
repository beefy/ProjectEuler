import java.lang.Math;

class Main {
    public static void main(String[] args) {
        int range_start = 1;
        int range_end = 20;
        int counter = range_end + 1;
        while(true) {
            if(evenly_divisible(counter, range_start, range_end)) {
                System.out.println(counter);
                return;
            }
            counter += 1;
        }
    }

    public static boolean evenly_divisible(int n, int range_start, int range_end) {
        for(int i = range_start; i < range_end; i++) {
            if(n % i != 0) {
                return false;
            }
        }
        return true;
    }
}
