import java.lang.Math;
import java.util.ArrayList;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> sieve = sieve_of_eratosthenes(500000);
        System.out.println(sieve.get(10001));
    }

    public static ArrayList<Integer> sieve_of_eratosthenes(int n) {
        ArrayList<Integer> sieve = make_range(n);
        for(int i = 2; i < Math.sqrt(n); i++) {
            final int count = i;
            Function<Integer, Boolean> criteria = y -> y == count || y % count != 0;
            sieve = filter(sieve, criteria);
        }
        return sieve;
    }

    public static ArrayList<Integer> make_range(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < size; i++) {
            arr.add(i);
        }
        return arr;
    }

    public static ArrayList<Integer> filter(ArrayList<Integer> arr, Function<Integer, Boolean> criteria) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < arr.size(); i++) {
            if(criteria.apply(arr.get(i))) {
                ret.add(arr.get(i));
            }
        }
        return ret;
    }
}
