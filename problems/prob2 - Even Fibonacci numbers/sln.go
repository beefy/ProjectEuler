package main

import "fmt"

var fib_memo = make(map[int]int)

func main() {
	fib_memo[0] = 1
	fib_memo[1] = 1
	term_count := 2
	fib_value := fib(term_count)
	sum := fib_value
	for sum < 4000000 {
		term_count += 1
		fib_value := fib(term_count);
		if fib_value % 2 == 0 {
			sum += fib_value;
		}
	}
	fmt.Println(sum)
}

func fib(n int) int {
	memo_value, contains_key := fib_memo[n]
	if contains_key {
		return memo_value
	}

	fib_memo[n] = fib(n-1) + fib(n-2)
	return fib_memo[n]
}
