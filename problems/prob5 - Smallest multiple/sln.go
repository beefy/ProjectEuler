package main

import (
	"fmt"
)

func main() {
	range_start := 1
	range_end := 20
	counter := range_end + 1
	for true {
		if evenly_divisible(counter, range_start, range_end) {
			fmt.Println(counter)
			return
		}
		counter += 1
	}
}

func evenly_divisible(n int, range_start int, range_end int) bool {
	for i:= range_start; i < range_end; i++ {
		if n % i != 0 {
			return false
		}
	}
	return true
}
