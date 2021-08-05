package main

import (
	"fmt"
	"math"
)

func main() {
	seive := sieve_of_eratosthenes(500000)
	fmt.Println(seive[10001])
}

func sieve_of_eratosthenes(n int) []int {
	sieve := make_range(n)
	for i := 2; i < int(math.Sqrt(float64(n))); i++ {
		criteria := func(y int) bool {
			return y == i || y % i != 0
		}
		sieve = filter(sieve, criteria)
	}
	return sieve;
}

func make_range(size int) []int {
	arr := make([]int, size)
	for i := range arr {
		arr[i] = i
	}
	return arr
}

func filter(arr []int, criteria func(int) bool) []int {
	ret := make([]int, 0)
	for _, i := range arr {
		if criteria(i) {
			ret = append(ret, i)
		}
	}
	return ret
}
