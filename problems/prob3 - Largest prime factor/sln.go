package main

import (
	"fmt"
	"math"
)

func main() {
	i := 600851475143
	fmt.Println(largest_prime_factor(i))
}

func largest_prime_factor(n int) int {
	largest := 1

	// check if n is even
	for n % 2 == 0 {
		largest = 2
		n /= 2
	}

	// check odd numbers
	for i := 3; i <= int(math.Sqrt(float64(n))); i += 2 {
		// check if `i` is a factor
		for n % i == 0 {
			largest = i // we know i > largest
			n /= i
		}
	}

	// check for prime number factors
	if n > 2 && n > largest {
		largest = n
	}

	return largest;
}
