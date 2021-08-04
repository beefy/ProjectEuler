import java.util.Hashtable;


class Main {
    static Hashtable<Integer, Integer> fib_memo = new Hashtable<Integer, Integer>();

    public static void main(String[] args) {
        // base case
        fib_memo.put(0, 1);
        fib_memo.put(1, 1);
        Integer term_count = 2;
        Integer fib_value = fib(term_count);
        Integer sum = fib_value;
        while(fib_value < 4000000) {
            term_count += 1;
            fib_value = fib(term_count);
            if(fib_value % 2 == 0) {
                sum += fib_value;
            }
        }

        System.out.println(sum);
    }

    public static Integer fib(Integer n) {
        // check if n is memoized
        if(fib_memo.containsKey(n)) {
            return fib_memo.get(n);
        }

        // otherwise calculate it
        Integer fib_result = fib(n-1) + fib(n-2);
        fib_memo.put(n, fib_result);
        return fib_result;
    }
}
