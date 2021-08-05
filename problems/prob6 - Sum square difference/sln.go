package main

import (
	"fmt"
)

func main() {
	fmt.Println(square_of_sum(100) - sum_of_square(100))
}

func square_of_sum(n int) int {
	sum := (n / 2) * (1 + n);
	return sum * sum;
}

func sum_of_square(n int) int {
	return (n * (n + 1) * (2 * n + 1)) / 6;
}

